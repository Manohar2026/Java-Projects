package com.example.crud.Service;

import com.example.crud.Entity.Student;
import com.example.crud.Repository.StudentRepository;
import com.example.crud.dto.StudentRequestDto;
import com.example.crud.dto.StudentResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponseDto save(StudentRequestDto studentReqDto) {
        Student student = mapToEntity(studentReqDto);
        Student student1 = studentRepository.save(student);
        return mapToDto(student1);
    }

    private Student mapToEntity(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setId(studentRequestDto.getId());
        student.setName(studentRequestDto.getName());
        student.setEmail(studentRequestDto.getEmail());
        student.setCourse(studentRequestDto.getCourse());

        return student;
    }

    private StudentResponseDto mapToDto(Student student) {
        StudentResponseDto dto = new StudentResponseDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setCourse(student.getCourse());
        dto.setAge(student.getAge());

        return dto;
    }

    public List<StudentResponseDto> findAll() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponseDto> dtos = new ArrayList<>();

        for(Student student : students) {
            dtos.add(mapToDto(student));
        }

        return dtos;
    }

    public StudentResponseDto findById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        return mapToDto(student);
    }

    public StudentResponseDto updateStudent(Long id, StudentRequestDto studentReqDto) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setName(studentReqDto.getName());
        existingStudent.setEmail(studentReqDto.getEmail());
        existingStudent.setAge(studentReqDto.getAge());
        existingStudent.setCourse(studentReqDto.getCourse());

        Student student = studentRepository.save(existingStudent);

        return mapToDto(student);
    }

    public String deleteStudentById(Long id) {
        studentRepository.deleteById(id);
        return "Student deleted successfully";
    }
}
