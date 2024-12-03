package com.internlink.service;

import com.internlink.dto.StudentDTO;

public interface StudentService {
    // Add Student
    StudentDTO addStudent(StudentDTO studentDTO);

    // Update Student
    StudentDTO updateStudent(String id, StudentDTO studentDTO);

    // Delete Student
    void deleteStudent(String id);

    // Get Student by Email
    StudentDTO getStudentByEmail(String email);
}
