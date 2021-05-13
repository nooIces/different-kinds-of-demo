package com.example.spring.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class SortBCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("this is B");
        System.out.print("this must be running slower than A");
        System.out.println();
    }
}
