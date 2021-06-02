package com.example.spring.scope.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("session")
public class SessionBean {

    private final UUID uuid;

    public SessionBean(){
        this.uuid = UUID.randomUUID();
        System.out.println("create session bean" + this.uuid);
    }

    public void print() {
        System.out.println("SessionBean: " + this.uuid.toString());
    }

}
