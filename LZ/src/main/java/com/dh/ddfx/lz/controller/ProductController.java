package com.dh.ddfx.lz.controller;

import com.dh.ddfx.lz.module.Product;
import com.dh.ddfx.lz.module.request.PageCommonRequest;
import com.dh.ddfx.lz.module.request.ProductUpdateRequest;
import com.dh.ddfx.lz.module.response.PageCommonResponse;
import com.dh.ddfx.lz.module.response.PageModel;
import com.dh.ddfx.lz.module.response.ResponseCommonModel;
import com.dh.ddfx.lz.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author DELL
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping(value = "list",produces = "application/json;charset=UTF-8")
    public PageCommonResponse<Product> list(@RequestBody PageCommonRequest request){
        PageCommonResponse<Product> result = new PageCommonResponse<>();
        PageModel<Product> pageModel = productService.list(request);
        result.setPageModel(pageModel);
        return result;
    }
    @PostMapping(value = "add",produces = "application/json;charset=UTF-8")
    public ResponseCommonModel add(@RequestBody Product request){
        ResponseCommonModel result = productService.add(request);
        return result;
    }

    @GetMapping(value = "delete/{index}",produces = "application/json;charset=UTF-8")
    public ResponseCommonModel delete(@PathVariable String  index){
        ResponseCommonModel result = productService.delete(index);
        return result;
    }

    @PostMapping(value = "update",produces = "application/json;charset=UTF-8")
    public ResponseCommonModel update(@RequestBody ProductUpdateRequest request){
        ResponseCommonModel result = productService.update(request);
        return result;
    }
}
