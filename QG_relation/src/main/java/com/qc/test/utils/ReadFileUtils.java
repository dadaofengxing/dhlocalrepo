package com.qc.test.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by duh on 2018/5/18 11:13.
 * Email:duh@elab-plus.com
 * Version:v1.0
 */
public class ReadFileUtils {
    private static String resourceHead = "file:/";
    private static BufferedReader br;
    private static void setBufferedReader(String filePath) {
        try {
            File file = new File(filePath);
            if(file.exists()){
                System.out.println("file exists");
            }else {
                System.out.println("file not found");
                return;
            }
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static List<String> getFileContent(String fileName){
        String filePath = ReadFileUtils.class.getResource("/").toString().substring(resourceHead.length());
        setBufferedReader(filePath+fileName);
        String info = "";
        List<String> list = new ArrayList<>();
        try {
            while (null != br && (info=br.readLine())!=null){
                list.add(info);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(null != br){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String file = "people.txt";
//        String path = ReadFileUtils.class.getResource("").toString();
        String path2 = ReadFileUtils.class.getResource("/").toString().substring(resourceHead.length());
//        System.out.println(path);
        System.out.println(path2+file);
        List<String> list = getFileContent(path2+file);
        System.out.println(list);
    }
}
