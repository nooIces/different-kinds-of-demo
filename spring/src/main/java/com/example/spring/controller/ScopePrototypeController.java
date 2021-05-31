package com.example.spring.controller;

import com.example.spring.bean.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/prototype")
@Scope("prototype")
public class ScopePrototypeController {

    @Resource
    @Qualifier("protoTypeUser")
    private User protoTypeUser;
    @Resource
    @Qualifier("protoTypeProxyUser")
    private User protoTypeProxyUser;
    @Resource
    @Qualifier("testA")
    private User notChangeUser;

    @GetMapping("/testProtoType")
    public String testProtoType(){
        // 每次请求会新生成一个bean
        return Thread.currentThread().getId() + "--" + notChangeUser.getUsername() + "  " + notChangeUser.getPassword() + "\r\n"
                + protoTypeUser.getUsername() + " " + protoTypeUser.getUsername();
    }

    @GetMapping("/testProxyTarget")
    public String testProxy(){
        // 每次调用都会新生成一个bean
        return Thread.currentThread().getId() + "--" + protoTypeProxyUser.getUsername() + "\r\n"
                + protoTypeProxyUser.getUsername();
    }

}
