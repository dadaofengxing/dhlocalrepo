package com.dh.ddfx.utils;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by duh on 2018/5/28 20:05.
 * Email:duh@elab-plus.com
 * Version:v1.0
 */
public class FileWriterUtils {
    static String path = FileWriterUtils.class.getResource("/").getPath();
    public static void write2File(List<String> contentList) throws Exception{
        long time = System.currentTimeMillis();
        File file = new File(path+time+".txt");
        if(!file.exists()){
            file.createNewFile();
        }
        PrintWriter pw = new PrintWriter(file);
        for(String content : contentList){
            pw.println(content);
        }
        pw.close();
    }
}
