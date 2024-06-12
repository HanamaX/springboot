package com.example.demo.Employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    @Query("SELECT s FROM Employee s WHERE s.name=?1")
    Optional<Employee>findByName(String name);


    @Query("SELECT s FROM Employee s WHERE s.salary=:salary")
    List<Employee> findBySalary(Double salary);
    
} 