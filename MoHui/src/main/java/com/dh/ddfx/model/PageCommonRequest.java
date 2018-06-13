package com.dh.ddfx.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author  duh on 2018/5/15 16:40.
 * Email:duh@elab-plus.com
 * Version:v1.0
 */
@ApiModel("公共查询列表请求体")
public class PageCommonRequest {
    @ApiModelProperty(name = "pageNo",value = "列表第几页数",example = "1",required = true)
    private int pageNo = 1;
    @ApiModelProperty(name = "pageSize",value = "列表长度",example = "10",required = true)
    private int pageSize =10;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
