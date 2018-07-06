package com.dh.ddfx.lz.module.request;

import com.dh.ddfx.lz.module.Product;

/**
 * @author duh
 * @create 2018/7/6 11:54
 * @email duh@elab-plus.com
 **/
public class ProductUpdateRequest extends Product{
    private int index;

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public void setIndex(int index) {
        this.index = index;
    }
}
