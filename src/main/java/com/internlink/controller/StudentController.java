package com.internlink.controller;
import com.internlink.dto.StudentDTO;
import com.internlink.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // Add Student
    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO response = studentService.addStudent(studentDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Update Student
    @PutMapping("/{email}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable String email, @RequestBody StudentDTO studentDTO) {
        StudentDTO response = studentService.updateStudent(email, studentDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Delete Student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get Student by Email
    @GetMapping("/email/{email}")
    public ResponseEntity<StudentDTO> getStudentByEmail(@PathVariable String email) {
        StudentDTO response = studentService.getStudentByEmail(email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
