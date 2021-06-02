package com.example.spring.scope.instance;

import com.example.spring.scope.bean.RequestBean;
import com.example.spring.scope.bean.SessionBean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BeanInstance {

    @Resource
    private SessionBean sessionBean;
    @Resource
    private RequestBean requestBean;

    public BeanInstance() {
        System.out.println("create BeanInstance");
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public RequestBean getRequestBean() {
        return requestBean;
    }
}
