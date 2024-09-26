package com.schoolapp.schoolapplication.controller;

import com.schoolapp.schoolapplication.dto.StudentDTO;
import com.schoolapp.schoolapplication.dto.StudentSaveDTO;
import com.schoolapp.schoolapplication.dto.StudentUpdateDTO;
import com.schoolapp.schoolapplication.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private IStudentService IStudentService;

    @PostMapping(path = "/save")
    public String saveStudent(@RequestBody StudentSaveDTO studentSaveDTO)
    {
        return IStudentService.addStudent(studentSaveDTO);
    }

    @GetMapping(path = "/getAllStudents")
    public List<StudentDTO> getAllStudent() {
        return IStudentService.getAllStudents();
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO) {
        return IStudentService.updateStudent(studentUpdateDTO);
    }

    @DeleteMapping("/deletestudentid/{id}")
    public String deleteStudent(@PathVariable int id) {
        boolean isDeleted = IStudentService.deleteStudent(id);
        return isDeleted ? "Student deleted successfully!" : "Student ID does not exist.";
    }

}
