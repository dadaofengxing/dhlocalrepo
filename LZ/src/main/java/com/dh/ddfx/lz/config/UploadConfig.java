package com.dh.ddfx.lz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author duh
 * @create 2018/7/10 13:50
 * @email duh@elab-plus.com
 **/
@ConfigurationProperties(prefix = "uploadconfig")
@Component
public class UploadConfig {
    private String tempStoragePath;
    private String base64Folder;
    private int fileMaxSize;
    private int totalFileMaxSize;
    private String exts;

    public String getTempStoragePath() {
        return tempStoragePath;
    }

    public void setTempStoragePath(String tempStoragePath) {
        this.tempStoragePath = tempStoragePath;
    }

    public String getBase64Folder() {
        return base64Folder;
    }

    public void setBase64Folder(String base64Folder) {
        this.base64Folder = base64Folder;
    }

    public int getFileMaxSize() {
        return fileMaxSize;
    }

    public void setFileMaxSize(int fileMaxSize) {
        this.fileMaxSize = fileMaxSize;
    }

    public int getTotalFileMaxSize() {
        return totalFileMaxSize;
    }

    public void setTotalFileMaxSize(int totalFileMaxSize) {
        this.totalFileMaxSize = totalFileMaxSize;
    }

    public String getExts() {
        return exts;
    }

    public void setExts(String exts) {
        this.exts = exts;
    }
}
