package com.Practical;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class CrudAppApplication {
    private static final Logger logger = LoggerFactory.getLogger(CrudAppApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CrudAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataInitializer(EmployeeRepository employeeRepository) {
        return args -> {
            employeeRepository.save(new Employee("John Doe", "Developer"));
            employeeRepository.save(new Employee("Jane Smith", "Manager"));
            employeeRepository.save(new Employee("Samuel Green", "Analyst"));
            logger.info("Data has been initialized");
        };
    }
}