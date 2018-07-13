package com.dh.ddfx.lz.service;

import com.dh.ddfx.lz.module.response.UploadResponse;
import org.springframework.web.multipart.MultipartFile; /**
 * @author duh
 * @create 2018/7/13 17:16
 * @email duh@elab-plus.com
 **/
public interface IUploadService {
    UploadResponse uploadImage(MultipartFile file);
}
