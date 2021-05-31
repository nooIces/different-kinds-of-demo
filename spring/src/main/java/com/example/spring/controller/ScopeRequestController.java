package com.example.spring.controller;

import com.example.spring.bean.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/request")
@Scope("request")
public class ScopeRequestController {

    @Resource
    @Qualifier("protoTypeUser")
    private User protoTypeUser;

    @RequestMapping("/test")
    public String test() {
        return protoTypeUser.getUsername() + "-" + protoTypeUser.getPassword();
    }

}
