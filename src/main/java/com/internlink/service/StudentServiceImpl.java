package com.internlink.service;

import com.internlink.dto.StudentDTO;
import com.internlink.model.Student;
import com.internlink.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    // Add Student
    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) {
        Student student = mapToEntity(studentDTO);
        student = studentRepository.save(student);
        return mapToDTO(student);
    }

    // Update Student
    @Override
    public StudentDTO updateStudent(String email, StudentDTO studentRequestDTO) {
        Optional<Student> existingStudentOpt = studentRepository.findByEmail(email);
        if (existingStudentOpt.isEmpty()) {
            throw new RuntimeException("Student with email " + email + " not found");
        }
        Student existingStudent = existingStudentOpt.get();
        existingStudent.setFirstname(studentRequestDTO.getFirstname());
        existingStudent.setLastname(studentRequestDTO.getLastname());
        existingStudent.setUsername(studentRequestDTO.getUsername());
        existingStudent.setEmail(studentRequestDTO.getEmail());
        existingStudent.setPhoneNumber(studentRequestDTO.getPhoneNumber());
        existingStudent.setSkill(studentRequestDTO.getSkill());
        existingStudent.setBio(studentRequestDTO.getBio());
        existingStudent = studentRepository.save(existingStudent);
        return mapToDTO(existingStudent);
    }

    // Delete Student
    @Override
    public void deleteStudent(String id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student with ID " + id + " not found");
        }
        studentRepository.deleteById(id);
    }

    // Get Student by Email
    @Override
    public StudentDTO getStudentByEmail(String email) {
        Optional<Student> studentOpt = studentRepository.findByEmail(email);
        if (studentOpt.isEmpty()) {
            throw new RuntimeException("Student with email " + email + " not found");
        }
        return mapToDTO(studentOpt.get());
    }

    // Mapper: DTO to Entity
    private Student mapToEntity(StudentDTO dto) {
        Student student = new Student();
        student.setFirstname(dto.getFirstname());
        student.setLastname(dto.getLastname());
        student.setUsername(dto.getUsername());
        student.setEmail(dto.getEmail());
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setSkill(dto.getSkill());
        student.setBio(dto.getBio());
        return student;
    }

    // Mapper: Entity to DTO
    private StudentDTO mapToDTO(Student entity) {
        return new StudentDTO(
                entity.getFirstname(),
                entity.getLastname(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getSkill(),
                entity.getBio()
        );
    }
}
