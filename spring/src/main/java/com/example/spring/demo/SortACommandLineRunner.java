package com.example.spring.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class SortACommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("this is A");
        System.out.print("this must be running faster than B");
        System.out.println();
    }
}
