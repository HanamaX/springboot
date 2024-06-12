package com.example.demo.Employee;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepo repository){
        return args -> {
            Employee mariam = new Employee(
                            "Mariam",
                            LocalDate.of(2000, Month.JANUARY, 5),
                            20000.00
                        );

            Employee alex = new Employee( 
                "Alex",
                LocalDate.of(2004, Month.JANUARY, 5),
                350000.00
            );

            repository.saveAll(
                List.of(mariam, alex)
            );



        };
    }
}
