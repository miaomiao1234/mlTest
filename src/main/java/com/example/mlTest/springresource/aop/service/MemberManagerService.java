package com.example.mlTest.springresource.aop.service;

import com.example.mlTest.springresource.aop.model.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author miaoliang
 * @since 6/30/21 4:32 PM
 */
@Service
public class MemberManagerService {

    private final static Logger log = LoggerFactory.getLogger(MemberManagerService.class);

    public boolean add(Member member){
        log.info("add success!");
        return true;
    }

    public boolean delete(Member member) throws Exception {
        log.info("delete success!");
        if (true) throw new Exception("myself throw exceptions");
        return true;
    }

    public boolean edit(){
        log.info("edit success!");
        return true;
    }

    public List getMembets(){
        log.info("select success!");
        return Arrays.asList(1,2,3);
    }

}
