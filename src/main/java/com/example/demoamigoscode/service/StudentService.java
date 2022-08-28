package com.example.demoamigoscode.service;

import com.example.demoamigoscode.classes.Student;
import com.example.demoamigoscode.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    public StudentRepository studentRepository;
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional=studentRepository.findStudentByName(student.getName());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Name is present,register is allowed");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exist = studentRepository.existsById(studentId);
        if(!exist){
            throw new IllegalStateException("this student with id " + studentId + "does not exist");
        }
        studentRepository.deleteById(studentId);
    }


}
