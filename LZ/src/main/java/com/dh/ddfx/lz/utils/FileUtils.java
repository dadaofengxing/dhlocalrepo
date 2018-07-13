package com.dh.ddfx.lz.utils;

import org.springframework.web.multipart.MultipartFile;

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

    public static void createLocalFile(String filePath, MultipartFile file) {
        File newFile = new File(filePath);
        BufferedInputStream bStream = null;
        FileOutputStream fos = null;
        InputStream is = null;
        if(!newFile.exists()){
            try {
                is = file.getInputStream();
                newFile.createNewFile();
                fos = new FileOutputStream(newFile);
                bStream = new BufferedInputStream(is);
                int bufferLength = 1024;
                byte[] buffer = new byte[bufferLength];
                int left = is.available();
                while (true){
                    // 剩余的数据比1024字节少，一位一位读出再写入目的文件
                    if (is.available() < 1024) {
                        int c = -1;
                        while ((c = is.read()) != -1) {
                            fos.write(c);
                        }
                        break;
                    } else {
                        // 从来源文件读取数据至缓冲区
                        is.read(buffer);
                        // 将数组数据写入目的文件
                        fos.write(buffer);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(null != is){
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(null != bStream){
                    try {
                        bStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(null != fos){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void deleteTempFile(String filePath) {
        File file = new File(filePath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
        }
    }
}
