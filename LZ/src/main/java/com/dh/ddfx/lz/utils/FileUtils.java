package com.dh.ddfx.lz.utils;

import java.io.*;

/**
 * @author duh
 * @create 2018/7/6 11:27
 * @email duh@elab-plus.com
 **/
public class FileUtils {
    private static BufferedReader bufferedReader;
    private static PrintWriter printWriter;

    public static String readContent(String filePath){
        StringBuffer stringBuffer = new StringBuffer("");
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            String content = "";
            while (null != (content=bufferedReader.readLine())){
                    stringBuffer.append(content);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally {
            if(null != bufferedReader){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return stringBuffer.toString();
    }

    public static void coverFileContent(String filePath,String content){
        try {
            File file = new File(filePath);
            if(!file.exists()){
                file.createNewFile();
            }
            System.out.println(file.getAbsolutePath());
            printWriter = new PrintWriter(filePath);
            printWriter.write(content);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }
    }
}
