package com.example.spring.config;

import com.example.spring.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.util.Random;

@Configuration
public class DemoConfig {


    @Bean(name = "testA")
    public User aUser() {
        User user = new User();
        user.setUsername("wwy");
        user.setPassword("111");
        return user;
    }

    @Bean(name = "testB")
    public User bUser() {
        User user = new User();
        user.setUsername("wwx");
        user.setPassword("222");
        return user;
    }

    @Bean(name = "protoTypeUser")
    @Scope(value = "prototype")
    public User protoTypeUser(){
        User user = new User();
        user.setUsername(new Random().nextInt(1000) + "");
        user.setPassword("333");
        return user;
    }

    @Bean(name = "requestUser")
    @Scope("request")
    public User requestUser() {
        User user = new User();
        user.setUsername(new Random().nextInt(1000) + "");
        user.setPassword("444");
        return user;
    }

    @Bean(name = "protoTypeProxyUser")
    @Scope(value = "prototype", proxyMode= ScopedProxyMode.TARGET_CLASS)
    public User protoTypeProxyUser(){
        User user = new User();
        user.setUsername(new Random().nextInt(1000) + "");
        user.setPassword("333");
        return user;
    }
}
