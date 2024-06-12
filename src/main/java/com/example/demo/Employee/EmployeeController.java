package com.example.demo.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/abc")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    
    @GetMapping 
    public List<Employee> getEmp(@RequestParam(required = false) Double salary){
        if(salary == null)  return employeeService.getEmp();
        return employeeService.getEmp(salary);
    }


    @PostMapping
    public void postEmp(@RequestBody Employee employee){
         employeeService.postEmp(employee);
    }

    @DeleteMapping(path = "{EmpId}")
    public void delEmp(@PathVariable("EmpId") Long EmpId){
        employeeService.delEmp(EmpId);
    }

    @PutMapping(path ="{EmpId}")
    public void putEmp(@PathVariable("EmpId") Long EmpId,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) Double salary){
                        employeeService.putEmp(EmpId,name,salary);
                       }
}
