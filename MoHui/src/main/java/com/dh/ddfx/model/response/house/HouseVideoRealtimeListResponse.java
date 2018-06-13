package com.dh.ddfx.model.response.house;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;

/**
 * @author duh on 2018/6/8 16:53.
 * Email:duh@elab-plus.com
 * Version:v1.0
 */
@Api(value = "直播分页列表响应体")
public class HouseVideoRealtimeListResponse {
    @ApiModelProperty(name = "id", value = "楼盘视频直播id")
    protected String id;


    @ApiModelProperty(name = "title", value = "直播名称")
    protected String title;

    @ApiModelProperty(name = "type", value = "1正在直播2预告3直播结束")
    protected String type;

    @ApiModelProperty(name = "hostCustomerid", value = "主持人")
    @Column(name = "host_customerid")
    protected String hostCustomerid;

    @ApiModelProperty(name = "status", value = "状态 1：有效 -1：无效")
    protected String status;


    @ApiModelProperty(name = "sort", value = "排序号")
    protected String sort;

    @ApiModelProperty(name = "realtimeStarttime", value = "直播开始时间")
    @Column(name = "realtime_starttime")
    protected String realtimeStarttime;

    @ApiModelProperty(name = "realtimeEndtime", value = "直播结束时间")
    @Column(name = "realtime_endtime")
    protected String realtimeEndtime;


    @ApiModelProperty(name = "name", value = "customer_ext.name")
    private String name;

    public void init(){
        id="1";
        title="sjdofwie";
        type="1";
        status="1";
        sort="1";
        realtimeStarttime="2017-09-12 15:12:00";
        realtimeEndtime="2017-09-12 15:12:00";
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHostCustomerid() {
        return hostCustomerid;
    }

    public void setHostCustomerid(String hostCustomerid) {
        this.hostCustomerid = hostCustomerid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getRealtimeStarttime() {
        return realtimeStarttime;
    }

    public void setRealtimeStarttime(String realtimeStarttime) {
        this.realtimeStarttime = realtimeStarttime;
    }

    public String getRealtimeEndtime() {
        return realtimeEndtime;
    }

    public void setRealtimeEndtime(String realtimeEndtime) {
        this.realtimeEndtime = realtimeEndtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
