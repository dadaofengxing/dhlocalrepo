package smail;

import com.baidu.aip.ocr.AipOcr;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;

/**
 * @Title: baidu
 * @Prject: ORCDemo
 * @Package: PACKAGE_NAME
 * @Description 百度文字识别API
 * @author: willinggod
 * @date: 2018/3/7 19:48
 * @version: V1.0
 * Copyright  2018 中软华腾. All rights reserved.
 */
public class Ocr {
    //设置APPID/AK/SK
    public static final String APP_ID = "10893452";
    public static final String API_KEY = "06K4VIACIth5jHxNRiLYtWmh";
    public static final String SECRET_KEY = "lohGzg1yxuAnCwV1OXOrYL0DZ6c77xwI";
    public static void main(String[] args) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
   /*     client.setHttpProxy("proxy_host", "");  // 设置http代理
        client.setSocketProxy("proxy_host", "");  // 设置socket代理*/

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
       /* System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");*/

        // 调用接口
        String path = "D:\\aia\\java-sdk-master\\ORCDemo\\src\\shibie.jpg";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }

    //解析前台传递的图片文件
    public static OcrEntity ORCTextFromImage(byte[] image){
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        JSONObject res = client.basicGeneral(image,new HashMap<String, String>());
        Gson gson=new Gson();
        OcrEntity ocrEntity=gson.fromJson(res.toString(),OcrEntity.class);
        return ocrEntity;
    }
    //解析前台传递的保单文件
    public static OcrEntity ORCTextFromPolicyImage(byte[] image){
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        JSONObject res = client.basicGeneral(image,new HashMap<String, String>());
        Gson gson=new Gson();
        OcrEntity ocrEntity=gson.fromJson(res.toString(),OcrEntity.class);
        return ocrEntity;
    }
}
