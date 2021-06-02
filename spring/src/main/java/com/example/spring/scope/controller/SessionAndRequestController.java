package com.example.spring.scope.controller;

import com.example.spring.scope.instance.BeanInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/session")
@SessionAttributes("user")
public class SessionAndRequestController {

    @Resource
    private BeanInstance beanInstanceA;
    @Resource
    private BeanInstance beanInstanceB;

    @GetMapping("/login")
    public String login(String name, Model model, HttpServletRequest request, HttpSession session) {
        model.addAttribute("user", name);
        System.out.println("SessionBean-1");
        beanInstanceA.getSessionBean().print();
        System.out.println("SessionBean-2");
        beanInstanceB.getSessionBean().print();
        System.out.println("RequestBean-1");
        beanInstanceA.getRequestBean().print();
        System.out.println("RequestBean-2");
        beanInstanceB.getRequestBean().print();
        return "user/check";
    }

    @GetMapping("/check")
    public String check(Model model, HttpServletRequest request, HttpSession session) {
        System.out.println("check SessionBean-1");
        beanInstanceA.getSessionBean().print();
        System.out.println("check SessionBean-2");
        beanInstanceB.getSessionBean().print();
        System.out.println("check RequestBean-1");
        beanInstanceA.getRequestBean().print();
        System.out.println("check RequestBean-2");
        beanInstanceB.getRequestBean().print();
        return "user/check";
    }
}
