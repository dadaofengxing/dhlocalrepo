package com.dh.ddfx.model.request.house;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhub1@elab-plus.com
 * Created by Swing on 2018/6/6.
 */
@ApiModel(description = "楼盘详情请求")
public class HouseDetailRequest {

    @ApiModelProperty(name = "id", value = "楼盘id", required = true, example = "1")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
