package com.dh.ddfx.lz.service.impl;

import com.dh.ddfx.lz.config.QiNiuConf;
import com.dh.ddfx.lz.config.UploadConfig;
import com.dh.ddfx.lz.module.response.UploadResponse;
import com.dh.ddfx.lz.service.IUploadService;
import com.dh.ddfx.lz.utils.FileUtils;
import com.dh.ddfx.lz.utils.QiniuUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author duh
 * @create 2018/7/13 17:18
 * @email duh@elab-plus.com
 **/
@Service("uploadService")
public class QiNiuUploadServiceImpl implements IUploadService {
    @Autowired
    private QiNiuConf qiNiuConf;
    @Autowired
    private UploadConfig uploadConfig;

    @Override
    public UploadResponse uploadImage(MultipartFile file) {
        return upload(file);
    }
    private UploadResponse upload(MultipartFile file){
        UploadResponse response = new UploadResponse();
        String fileName = file.getOriginalFilename();
        String newFilePath = uploadConfig.getTempStoragePath()+fileName;
        FileUtils.createLocalFile(newFilePath,file);
        QiniuUploadUtils.simpleUpload(qiNiuConf,fileName,newFilePath);
        FileUtils.deleteTempFile(newFilePath);
        response.setFileName(fileName);
        response.setFilePath(qiNiuConf.getResultUrl()+fileName);
        response.setOriginalFileName(fileName);
        return response;
    }
}
