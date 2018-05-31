package smail;

import com.google.gson.Gson;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Title: OcrOrange
 * @Prject: ORCDemo
 * @Package: smail
 * @Description:
 * @author: willinggod
 * @date: 2018/3/8 20:42
 * @version: V1.0
 * Copyright  2018 中软华腾. All rights reserved.
 */
public class OcrOrangePolicy extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String text="识别的文字内容为:";
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("contentType", "text/html; charset=utf-8");
        if (ServletFileUpload.isMultipartContent(request)) {
            // 磁盘
            FileItemFactory factory = new DiskFileItemFactory();
            // 文件
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                List<FileItem> files = upload.parseRequest(request);
                for (FileItem file : files) {
                    OcrEntity ocrEntity=Ocr.ORCTextFromPolicyImage(file.get());
                    Gson gson=new Gson();
                    text+=gson.toJson(ocrEntity.getWords_result()).toString();
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }finally {
                System.out.println("=---====="+text);
                resp.getWriter().write(text);
            }
        }
    }
}
