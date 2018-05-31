package orc.ocr;

import com.baidu.aip.ocr.AipOcr;
import com.google.gson.Gson;
import com.sun.xml.internal.ws.util.StringUtils;
import orc.modelOcr.*;
import org.json.JSONObject;
import orc.plainOcr.OcrEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public static final String APP_ID = "10937304";
    public static final String API_KEY = "ISa69cYHzMDB5raNsdL6GSf2";
    public static final String SECRET_KEY = "XGKQnGvW4AUiIWfdVZlqTvPBR76jhWXk";

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
        String path = "G:\\intelliJWorkSpace\\learn\\java-sdk-master\\ORCDemo\\src\\query.jpg";
        JSONObject res = client.custom(path,"3e01425d1e74f00ac3628f73929c3b96",new HashMap<String, String>());
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

    //自定义模板解析
    public static  ModelOcrResponse modelOcr(byte[] image,String modelId,HashMap<String, String> options){
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        JSONObject res=client.custom(image,modelId,options);
        Gson gson=new Gson();
        ModelOcrResponse modelOcrResponse=gson.fromJson(res.toString(),ModelOcrResponse.class);
        return modelOcrResponse;
    }

    //将自定义的模板的结果，转换成展示结果
    public static ModelOcr getModelOcr(ModelOcrResponse modelOcrResponse){
        ModelOcr modelOcr=new ModelOcr();
        if(null!=modelOcrResponse && modelOcrResponse.getError_code() ==0){
             if(null!=modelOcrResponse.getData()){
                 ModelOcrData modelOcrData=modelOcrResponse.getData();
                 if(null!=modelOcrData.getRet() && modelOcrData.getRet().size()>0){
                     List<ModelOcrText> words=new ArrayList<ModelOcrText>();
                     List<Ret> retList=modelOcrData.getRet();
                     for(Ret ret:retList){
                         ModelOcrText modelOcrText=new ModelOcrText();
                         if(null!=ret.getWord_name() && !"".equals(ret.getWord_name())){
                             String wordName=ret.getWord_name();
                             modelOcrText.setWord_name(wordName);
                         }
                         if(null!=ret.getWord() && !"".equals(ret.getWord())){
                             String word=ret.getWord();
                             modelOcrText.setWord(word);
                         }
                         words.add(modelOcrText);
                     }
                     modelOcr.setWords(words);
                 }
             }
        }
        return modelOcr;
    }




}
