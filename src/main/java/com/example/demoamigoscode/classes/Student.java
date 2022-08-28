package com.example.demoamigoscode.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity @Table(name = "Student")
public class Student {
    @Id @SequenceGenerator(name = "student_sequence",allocationSize = 1,sequenceName = "student_sequence")
    @GeneratedValue(strategy =SEQUENCE,
                    generator = "student_sequence")
    private Long id;
    @Column(nullable = false,columnDefinition = "TEXT",name = "nomComplet")
    private String name;
    @Transient
    private Integer age;
    @Column(name = "dateNaissance",columnDefinition = "DATE")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dob;

    public Student(Long id, String name, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
