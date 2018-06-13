package com.dh.ddfx.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author duh on 2018/5/14 20:26.
 * Email:duh@elab-plus.com
 * Version:v1.0
 */
@Controller
@RequestMapping("template")
@Api(tags = "DH模板模块") //swagger分类标题注解
public class DhTemplateController {

    @RequestMapping(value = "getTemplateList",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "获取模板列表",nickname = "duh")
    public String getTemplateList(){
        return "template";
    }
}
