package com.example.demoamigoscode;

import com.example.demoamigoscode.classes.Student;
import com.example.demoamigoscode.repository.StudentRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

import com.example.demoamigoscode.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication

public class DemoAmigoscodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAmigoscodeApplication.class, args);
	}
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private StudentService studentService;
	public List<Student> getStudent(){
		return studentService.getStudents();
	}
	@Bean
	CommandLineRunner commandLineRunner(){
	return args -> {
		Student mariam = new Student(null,"Mariam",LocalDate.of(2019,Month.AUGUST,19));
		Student samir = new Student(null,"Samir",LocalDate.of(2002,Month.DECEMBER,23));
		studentRepository.save(new Student(null,"Walid",LocalDate.of(1999, Month.NOVEMBER,10)));
		studentRepository.save(new Student(null,"Achraf",LocalDate.of(1996,Month.FEBRUARY,28)));
		studentRepository.saveAll(List.of(mariam,samir));

	};
	}

}
