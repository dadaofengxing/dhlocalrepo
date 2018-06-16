package com.dh.ddfx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GirlController {

    @GetMapping("girl")
    public String test(){
        return "b";
    }
}
