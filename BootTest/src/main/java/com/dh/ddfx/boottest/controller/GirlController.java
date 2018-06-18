package com.dh.ddfx.boottest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GirlController {

    @Value("${size}")
    private String size;

    @RequestMapping(value = "girl",method = RequestMethod.GET)
    public String test(){
        return "b";
    }

    @RequestMapping("size")
    public String getTheSize(){
        return size;
    }
}
