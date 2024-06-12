package com.example.demo.Employee;

import java.sql.Date;
import java.time.LocalDate;

import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class Employee {
    @Id
    @SequenceGenerator(allocationSize = 1 , name = "Id_gen" , sequenceName = "Id_gen")
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "Id_gen"  )

    private Long id;
    private String name;
    private LocalDate e_dob;

    @Transient
    private int yr;
    private Double salary;

    //Constructors
    public Employee(String name, LocalDate e_dob, Double salary) {
        this.name = name;
        this.e_dob = e_dob;
        this.salary = salary;
    }

    
    public Employee() {
    }




    //Setters and Getters
    public LocalDate getE_dob() {
        return e_dob;
    }

    
    
    public void setE_dob(LocalDate e_dob) {
        this.e_dob = e_dob;
    }
    public int getYr() {
        return Period.between(e_dob,LocalDate.now()).getYears();
    }
    
    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(final Double salary) {
        this.salary = salary;
    }


    public Long getId() {
        return id;
    }



}
