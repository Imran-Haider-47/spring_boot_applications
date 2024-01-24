package com.imhaider.springbootmysql.controller;

import com.imhaider.springbootmysql.entity.Student;
import com.imhaider.springbootmysql.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable final Integer id){
        return studentService.getStudent(id);
    }

    @PostMapping()
    public Student insert(@RequestBody final Student student){
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable final Integer id, @RequestBody final Student student){
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("{id}")
    public String deleteStudent(@PathVariable final Integer id){
        return studentService.deleteStudent(id);
    }



}
