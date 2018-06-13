package com.dh.ddfx.model.request.house;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhub1@elab-plus.com
 * Created by Swing on 2018/6/7.
 */
@ApiModel("楼盘上线请求")
public class HouseOnlineRequest {

    @ApiModelProperty(name = "id", value = "楼盘id", required = true, example = "1")
    private Integer id;

    @ApiModelProperty(name = "operation", value = "操作 1上线 -1下线", required = true, example = "1")
    private Integer operation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }
}
