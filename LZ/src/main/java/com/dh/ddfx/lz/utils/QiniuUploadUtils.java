package com.dh.ddfx.lz.utils;

import com.dh.ddfx.lz.config.QiNiuConf;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.File;

/**
 * @author duh
 * @create 2018/7/13 17:21
 * @email duh@elab-plus.com
 **/
public class QiniuUploadUtils {
    static UploadManager uploadManager = null;
    //默认不指定key的情况下，以文件内容的hash值作为文件名
    static String key = null;
    static{
        config();
    }
    private static void config(){
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
    }
    public static void simpleUpload(QiNiuConf qiNiuConf,String fileName,String file){
        Auth auth = Auth.create(qiNiuConf.getAccessKey(),qiNiuConf.getSecretKey());
        String upToken = auth.uploadToken(qiNiuConf.getBucketName());
        //如果是Windows情况下，格式是 D:\\qiniu\\test.png
        //linux 是 "/home/qiniu/test.png";
        try {
            Response response = uploadManager.put(file, fileName, upToken);
            System.out.println(response.statusCode);
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }
}
