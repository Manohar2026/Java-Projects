package com.example.crud.Controller;

import com.example.crud.Entity.Student;
import com.example.crud.Service.StudentService;
import com.example.crud.dto.StudentRequestDto;
import com.example.crud.dto.StudentResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public StudentResponseDto addStudent(@RequestBody StudentRequestDto studentReqDto) {
        return studentService.save(studentReqDto);
    }

    @GetMapping("/find")
    public List<StudentResponseDto> getStudents() {
        return studentService.findAll();
    }

    @GetMapping("/find/{id}")
    public StudentResponseDto getStudentById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        return studentService.deleteStudentById(id);
    }

    @PutMapping("/update/{id}")
    public StudentResponseDto updateStudent(
            @PathVariable Long id,
            @RequestBody StudentRequestDto studentReqDto) {

        return studentService.updateStudent(id, studentReqDto);
    }
}
