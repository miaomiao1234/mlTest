package com.example.mlTest.springresource.aop.service;

import com.example.mlTest.springresource.aop.model.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author miaoliang
 * @since 6/30/21 4:32 PM
 */
@Service
public class AuthService {

    private final static Logger log = LoggerFactory.getLogger(AuthService.class);

    public Member login(String name, String password){
        log.info("user logining...");
        return null;
    }

    public boolean logout(){
        log.info("logout success!!!");
        return true;
    }

}
