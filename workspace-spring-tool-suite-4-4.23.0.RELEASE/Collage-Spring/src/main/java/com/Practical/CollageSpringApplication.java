package com.Practical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:com/Practical/Con.xml")
public class CollageSpringApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CollageSpringApplication.class, args);
        Car car = (Car) context.getBean("Car");
        car.Drive();
        Bike bike = (Bike) context.getBean("Bike");
        bike.Drive();
    }

}