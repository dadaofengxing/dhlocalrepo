package com.dh.ddfx.lz.utils;

import com.dh.ddfx.lz.module.Product;
import com.dh.ddfx.lz.module.request.PageCommonRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author duh
 * @create 2018/7/6 12:07
 * @email duh@elab-plus.com
 **/
public class GetJsonStr {
    static Gson gson = new GsonBuilder().serializeNulls().create();
    public static void main(String[] args) {
        System.out.println(gson.toJson(new PageCommonRequest()));
    }
}
