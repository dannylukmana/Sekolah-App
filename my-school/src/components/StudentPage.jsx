import axios from "axios";
import { useEffect, useState } from "react";

const Student = () => {
  const [studentId, setId] = useState("");
  const [studentName, setStudentName] = useState("");
  const [teacherName, setTeacherName] = useState("");
  const [address, setAddress] = useState("");
  const [mobile, setMobile] = useState("");
  const [status, setStatus] = useState("");
  const [students, setStudents] = useState([]);
  const [isEditing, setIsEditing] = useState(false); 

  useEffect(() => {
    (async () => await Load())();
  }, []);
  
  async function Load() {
    const result = await axios.get("http://localhost:8089/api/v1/student/getAllStudents");
    setStudents(result.data);
    console.log(result);
  }
  
  async function save(event) {
    event.preventDefault();
    try {
      await axios.post("http://localhost:8089/api/v1/student/save", {
        studentName: studentName,
        teacherName: teacherName,
        address: address,
        mobile: mobile,
        status: status
      });
      alert("Student Registration Successfully");
      resetForm();
      Load();
    } catch (err) {
      alert(err);
    }
  }

  async function editStudent(student) {
    setStudentName(student.studentName);
    setTeacherName(student.teacherName);
    setAddress(student.address);
    setMobile(student.mobile);
    setStatus(student.status);
    setId(student.studentId);
    setIsEditing(true);
  }

  async function DeleteStudent(studentId) {
    await axios.delete("http://localhost:8089/api/v1/student/deletestudentid/" + studentId);
    alert("Student deleted Successfully");
    Load();
  }
  
  async function update(event) {
    event.preventDefault();
    try {
      await axios.put("http://localhost:8089/api/v1/student/update", {
        studentId: studentId,
        studentName: studentName,
        teacherName: teacherName,
        address: address,
        mobile: mobile,
        status: status
      });
      alert("Student Updated Successfully");
      resetForm();
      Load();
    } catch (err) {
      alert(err);
    }
  }

  function resetForm() {
    setId("");
    setStudentName("");
    setTeacherName("");
    setAddress("");
    setMobile("");
    setStatus("");
    setIsEditing(false); 
  }

  return (
    <div className="mt-8 p-5 bg-gray-200 border-neutral-900 shadow-2xl rounded-lg">
      <div className="w-full max-w-4xl mx-auto space-y-8 mb-12">
        <div className="flex justify-between items-center w-full">
          <h1 className="text-4xl font-extrabold tracking-tight text-gray-900 md:text-5xl lg:text-6xl dark:text-white" style={{ fontFamily: 'Bebas Neue, sans-serif' }}>
            Student Registration
          </h1>
        </div>

        <div className="flex flex-col w-full space-y-6 ">
          <input
            type="text"
            className="w-full border-b-2 border-zinc-800 py-3 pl-2 focus:outline-none hover:border-blue-500 focus:border-blue-500 rounded"
            placeholder="Student Name"
            id="studentname"
            value={studentName}
            onChange={(event) => setStudentName(event.target.value)}
          />
          <input
            type="text"
            className="w-full border-b-2 border-zinc-800 py-3 pl-2 focus:outline-none hover:border-blue-500 focus:border-blue-500 rounded"
            placeholder="Teacher Name"
            id="teachername"
            value={teacherName}
            onChange={(event) => setTeacherName(event.target.value)}
          />
          <input
            type="text"
            className="w-full border-b-2 border-zinc-800 py-3 pl-2 focus:outline-none hover:border-blue-500 focus:border-blue-500 rounded"
            placeholder="Address"
            id="address"
            value={address}
            onChange={(event) => setAddress(event.target.value)}
          />
          <input
            type="text"
            className="w-full border-b-2 border-zinc-800 py-3 pl-2 focus:outline-none hover:border-blue-500 focus:border-blue-500 rounded"
            placeholder="Phone Number"
            id="mobile"
            value={mobile}
            onChange={(event) => setMobile(event.target.value)}
          />
        </div>

        <div className="flex justify-end space-x-4 mt-6">
          {/* Conditionally render Create button based on isEditing state */}
          {!isEditing && (
            <button
              className="bg-blue-600 hover:bg-blue-800 text-white font-semibold py-2 px-6 rounded-lg transition duration-300 ease-in-out transform hover:scale-105 shadow-lg"
              onClick={save}
            >
              Create
            </button>
          )}
          {isEditing && ( // Conditionally render Update button
            <button
              className="bg-green-600 hover:bg-green-800 text-white font-semibold py-2 px-6 rounded-lg transition duration-300 ease-in-out transform hover:scale-105 shadow-lg"
              onClick={update}
            >
              Update
            </button>
          )}
        </div>
      </div>

      <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
        <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400">
          <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
              <th scope="col" className="px-6 py-3 text-center">No</th>
              <th scope="col" className="px-6 py-3">Student Name</th>
              <th scope="col" className="px-6 py-3">Teacher Name</th>
              <th scope="col" className="px-6 py-3">Address</th>
              <th scope="col" className="px-6 py-3">Mobile</th>
              <th scope="col" className="px-6 py-3">Action</th>
            </tr>
          </thead>
          <tbody>
            {students.length === 0 ? (
              <tr>
                <td colSpan="5" className="text-center py-4 text-gray-500 font-bold text-xl">
                    Student List is Currently Empty
                </td>

              </tr>
            ) : (
              students.map((student, index) => (
                <tr key={student.studentId} className="bg-white border-b dark:bg-gray-900 dark:border-gray-700">
                  <td className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white text-center">
                    {index + 1}
                  </td>
                  <td className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                    {student.studentName}
                  </td>
                  <td className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                    {student.teacherName}
                  </td>
                  <td className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                    {student.address}
                  </td>
                  <td className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                    {student.mobile}
                  </td>
                  <td className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                    <button
                      className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mr-2"
                      onClick={() => editStudent(student)}
                    >
                      Edit
                    </button>
                    <button
                      className="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded"
                      onClick={() => DeleteStudent(student.studentId)}
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              ))
            )}
          </tbody>

        </table>
      </div>

    </div>
  );
}

export default Student;
