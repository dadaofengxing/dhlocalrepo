package com.dh.ddfx.lz.controller;

import com.dh.ddfx.lz.module.response.UploadResponse;
import com.dh.ddfx.lz.service.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author duh
 * @create 2018/7/13 17:16
 * @email duh@elab-plus.com
 **/
@RestController
@RequestMapping("upload")
public class UploadController {
    @Autowired
    IUploadService uploadService;

    @PostMapping(value = "uploadImage",produces = "application/json;charset=UTF-8")
    public UploadResponse uploadImage(MultipartFile file){
        return uploadService.uploadImage(file);
    }
}
