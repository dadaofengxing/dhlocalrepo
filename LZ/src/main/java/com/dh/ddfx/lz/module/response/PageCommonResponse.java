package com.dh.ddfx.lz.module.response;

/**
 * @author duh
 * @create 2018/7/6 11:00
 * @email duh@elab-plus.com
 **/
public class PageCommonResponse<T> {
    private PageModel<T> pageModel;

    public PageModel getPageModel() {
        return pageModel;
    }

    public void setPageModel(PageModel<T> pageModel) {
        this.pageModel = pageModel;
    }
}
