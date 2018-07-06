package com.dh.ddfx.lz.module.request;

/**
 * @author duh
 * @create 2018/7/6 11:05
 * @email duh@elab-plus.com
 **/
public class PageCommonRequest {
    private int pageNo = 1;
    private int pageSize = 10;

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
