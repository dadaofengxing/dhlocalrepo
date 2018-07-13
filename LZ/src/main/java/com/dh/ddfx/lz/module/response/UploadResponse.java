package com.dh.ddfx.lz.module.response;

/**
 * @author duh
 * @create 2018/7/3 19:02
 * @email duh@elab-plus.com
 **/
public class UploadResponse {
    private String fileName;
    private String filePath;
    private String originalFileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }
}
