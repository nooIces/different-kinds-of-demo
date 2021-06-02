package com.example.spring.scope.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("request")
public class RequestBean {

    private final UUID uuid;

    public RequestBean(){
        this.uuid = UUID.randomUUID();
        System.out.println("create request bean" + this.uuid);
    }

    public void print() {
        System.out.println("RequestBean: " + this.uuid.toString());
    }

}
