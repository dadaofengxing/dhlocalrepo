package smail;

import com.google.gson.Gson;
import orc.modelOcr.ModelOcr;
import orc.modelOcr.ModelOcrResponse;
import orc.ocr.Ocr;
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
public class OcrOrange extends HttpServlet {
    private static String POLICY_TEMPLATESIGN ="3e01425d1e74f00ac3628f73929c3b96";
    public static final String JIHUASHU_templateSign = "117ff607cf46ce32a7d26eaaae98182f";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String text="识别的文字内容为:";
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("contentType", "text/html; charset=utf-8");
        String templateSign = POLICY_TEMPLATESIGN;
        String index = request.getParameter("index");
        if(null != index){
            templateSign = JIHUASHU_templateSign;
        }
        if (ServletFileUpload.isMultipartContent(request)) {
            // 磁盘
            FileItemFactory factory = new DiskFileItemFactory();
            // 文件
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                List<FileItem> files = upload.parseRequest(request);
                for (FileItem file : files) {
                    ModelOcrResponse modelOcrResponse= Ocr.modelOcr(file.get(), templateSign,null);
                    ModelOcr modelOcr=null;
                    if(null!=modelOcrResponse){
                         modelOcr= Ocr.getModelOcr(modelOcrResponse);
                    }
                    Gson gson=new Gson();
                    text+=gson.toJson(modelOcr).toString();
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
