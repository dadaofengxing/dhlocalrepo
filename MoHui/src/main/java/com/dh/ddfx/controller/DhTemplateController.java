package com.dh.ddfx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by duh on 2018/5/14 20:26.
 * Email:duh@elab-plus.com
 * Version:v1.0
 */
@Controller
@RequestMapping("template")

public class DhTemplateController {

    @RequestMapping(value = "getTemplateList",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getTemplateList(){
        return "template";
    }
}
