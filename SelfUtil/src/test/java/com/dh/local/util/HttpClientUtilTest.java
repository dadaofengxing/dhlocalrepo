package com.dh.local.util;

import static org.junit.Assert.*;


public class HttpClientUtilTest {


    @org.junit.Test
    public void sendGetRequest() {
        String url = "https://api2.mytoken.org/ticker/symbolpairlist?symbol_list=btc,eth,ltc,neo,eos,iota,lrc,qtum,ven,bnb,gxs,yoyow,xrp&timestamp=1522396030291&code=8d7a6d1598cd4991fe1b2561a6b33edd&platform=m";
        String data = HttpClientUtil.sendGetRequest(url,"UTF-8");
        System.out.println("result = " + data);
    }
}
