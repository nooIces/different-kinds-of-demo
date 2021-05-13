package com.example.spring.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("this is demo commandLineRunner implement");
    }
}
