package com.example.demoamigoscode.controller;

import com.example.demoamigoscode.classes.Student;
import com.example.demoamigoscode.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class StudentController {

    @Autowired
    public StudentService studentService;
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId ){
        studentService.deleteStudent(studentId);
    }

}
