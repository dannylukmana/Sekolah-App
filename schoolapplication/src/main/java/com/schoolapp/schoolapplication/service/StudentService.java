package com.schoolapp.schoolapplication.service;

import com.schoolapp.schoolapplication.dto.StudentDTO;
import com.schoolapp.schoolapplication.dto.StudentSaveDTO;
import com.schoolapp.schoolapplication.dto.StudentUpdateDTO;

import java.util.List;

/**
 * Interface for managing student operations.
 */
public interface StudentService {
    /**
     * Adds a new student.
     * @param studentSaveDTO the data transfer object containing student information
     * @return the name of the added student
     */
    String addStudent(StudentSaveDTO studentSaveDTO);

    /**
     * Retrieves all students.
     * @return a list of all student DTOs
     */
    List<StudentDTO> getAllStudents();

    /**
     * Updates an existing student.
     * @param studentUpdateDTO the data transfer object containing updated student information
     * @return the name of the updated student
     */
    String updateStudent(StudentUpdateDTO studentUpdateDTO);

    /**
     * Deletes a student by ID.
     * @param id the ID of the student to be deleted
     * @return true if the student was deleted, false otherwise
     */
    boolean deleteStudent(int id);
}

