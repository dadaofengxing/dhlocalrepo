package com.dh.ddfx.boottest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class GirlController {

    @RequestMapping(value = "girl",method = RequestMethod.GET)
    public String test(){
        return "b";
    }
}
