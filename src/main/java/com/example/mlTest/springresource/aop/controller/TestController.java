package com.example.mlTest.springresource.aop.controller;

import com.example.mlTest.springresource.aop.model.Member;
import com.example.mlTest.springresource.aop.service.MemberManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author miaoliang
 * @since 6/30/21 5:26 PM
 */
@RestController
public class TestController {

    @Autowired
    private MemberManagerService memberManagerService;

    @RequestMapping("add")
    public Object add(){
        return memberManagerService.add(new Member());
    }
    @RequestMapping("delete")
    public Object delete() throws Exception {
        return memberManagerService.delete(new Member());
    }
    @RequestMapping("edit")
    public Object edit(){
        return memberManagerService.edit();
    }
    @RequestMapping("select")
    public Object select(){
        return memberManagerService.getMembets();
    }

}
