package com.schoolapp.schoolapplication.service;

import com.schoolapp.schoolapplication.dto.StudentDTO;
import com.schoolapp.schoolapplication.dto.StudentSaveDTO;
import com.schoolapp.schoolapplication.dto.StudentUpdateDTO;
import com.schoolapp.schoolapplication.entity.Student;
import com.schoolapp.schoolapplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;;

    @Override
    public String addStudent(@RequestBody StudentSaveDTO studentSaveDTO) {
        Student student = new Student(
                studentSaveDTO.getStudentName(),
                studentSaveDTO.getAddress(),
                studentSaveDTO.getMobile(),
                studentSaveDTO.isActive(),
                studentSaveDTO.getTeacherName()
        );
        studentRepository.save(student);
        return "Student added: " + student.getStudentName();
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(s -> new StudentDTO(
                        s.getStudentId(),
                        s.getStudentName(),
                        s.getTeacherName(),
                        s.getAddress(),
                        s.getMobile(),
                        s.isActive()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public String updateStudent(StudentUpdateDTO studentUpdateDTO) {
        if (studentRepository.existsById(studentUpdateDTO.getStudentId())) {
            Student student = studentRepository.findById(studentUpdateDTO.getStudentId()).orElse(null);
            if (student != null) {
                student.setStudentName(studentUpdateDTO.getStudentName());
                student.setAddress(studentUpdateDTO.getAddress());
                student.setMobile(studentUpdateDTO.getMobile());
                student.setActive(studentUpdateDTO.isActive());
                student.setTeacherName(studentUpdateDTO.getTeacherName());
                studentRepository.save(student);
                return "Student updated successfully";
            }
        } else {
            System.out.println("Student ID does not exist");
        }
        return "Update failed";
    }

    @Override
    public boolean deleteStudent(int id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        System.out.println("Student ID does not exist");
        return false;
    }
}
