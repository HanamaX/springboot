package com.example.demo.Employee;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
     private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> getEmp(Double salary){
        return employeeRepo.findBySalary(salary);
    }

    public Employee postEmp(Employee emp){
        Optional<Employee> byName = employeeRepo.findByName(emp.getName());
        if(byName.isPresent()){
            throw new IllegalArgumentException("name taken");
        }
        return employeeRepo.save(emp);
    }

    public List<Employee> getEmp() {
        return employeeRepo.findAll();
    }

    public void delEmp(Long empId) {
        if (!employeeRepo.existsById(empId)) {
            throw new IllegalArgumentException("Employee not present");
        }
        employeeRepo.deleteById(empId);
        System.out.println("Employee deleted successfully");
    }

    @Transactional
    public void putEmp(Long EmpId,String name, Double salary) {
       Employee employee=employeeRepo.findById(EmpId)
       .orElseThrow(()-> new IllegalStateException("Employee not available"));

       if (name.compareToIgnoreCase(employee.getName()) !=0 && name!=null ){
        employee.setName(name);
       }

       if (salary != employee.getSalary() && salary!=null) {
        employee.setSalary(salary);
       }
    }
    
    

}
