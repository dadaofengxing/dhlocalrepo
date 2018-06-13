package com.dh.ddfx.controller;

import com.dh.ddfx.model.entity.house.HouseInfoEntity;
import com.dh.ddfx.model.request.house.AddHouseInfoRequest;
import com.dh.ddfx.model.response.house.HouseVideoRealtimeListResponse;
import com.dh.ddfx.service.ITemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    ITemplateService templateService;

    @RequestMapping(value = "getTemplateList",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "获取模板列表",nickname = "duh")
    public String getTemplateList(){
        return "template";
    }

    @RequestMapping(value = "getEntity",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "获取实体",nickname = "duh")
    public HouseInfoEntity getEntity(@RequestBody AddHouseInfoRequest request){
        HouseInfoEntity entity = new HouseInfoEntity();
        BeanUtils.copyProperties(request,entity);
        return entity;
    }

    @RequestMapping(value = "testService",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "测试service",nickname = "duh")
    public HouseVideoRealtimeListResponse testService(){
        return templateService.testService();
    }
}
