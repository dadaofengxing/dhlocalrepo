package com.dh.ddfx.lz.service.impl;

import com.dh.ddfx.lz.module.Product;
import com.dh.ddfx.lz.module.request.PageCommonRequest;
import com.dh.ddfx.lz.module.request.ProductUpdateRequest;
import com.dh.ddfx.lz.module.response.PageModel;
import com.dh.ddfx.lz.module.response.ResponseCommonModel;
import com.dh.ddfx.lz.service.IProductService;
import com.dh.ddfx.lz.utils.FileUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author DELL
 */
@Service("productService")
public class ProductServiceImpl implements IProductService {
    private static List<Product> productList = new ArrayList<>();
    private List<Product> deletedProductList = new ArrayList<>();
    private static int index = 0;
    private static Gson gson = new Gson();
    static{
        String list = FileUtils.readContent("product.json");
        productList = gson.fromJson(list,new TypeToken<List<Product>>(){}.getType());
    }
    @Override
    public PageModel<Product> list(PageCommonRequest request) {
        int begin = request.getPageNo()*request.getPageSize();
        int end = begin + request.getPageSize();
        if(productList.size() < end){
            end = productList.size();
        }
        List<Product> result = productList.subList(begin, end);
        PageModel<Product> pageModel = new PageModel<>();
        pageModel.setResultSet(result);
        return pageModel;
    }

    @Override
    public ResponseCommonModel add(Product request) {
        if(index == 0 && productList.size() > 0){
            String maxId = getMaxId();
            index = Integer.parseInt(maxId);
        }
        request.setId((index++)+"");
        productList.add(request);
        updateFile();
        ResponseCommonModel responseCommonModel = new ResponseCommonModel();
        responseCommonModel.setId(productList.size()+"");
        return responseCommonModel;
    }

    private String getMaxId(){
        return productList.get(productList.size()-1).getId();
    }
    @Override
    public ResponseCommonModel delete(String index) {
        Product product = productList.get(Integer.parseInt(index));
        deletedProductList.add(product);
        productList.remove(product);
        updateFile();
        updateDeleteFile();
        ResponseCommonModel responseCommonModel = new ResponseCommonModel();
        responseCommonModel.setId(index);
        return responseCommonModel;
    }

    @Override
    public ResponseCommonModel update(ProductUpdateRequest request) {
        Product product = productList.get(request.getIndex());
        BeanUtils.copyProperties(request,product);
        productList.set(request.getIndex(),product);
        updateFile();
        ResponseCommonModel responseCommonModel = new ResponseCommonModel();
        responseCommonModel.setId(product.getId());
        return responseCommonModel;
    }
    private void updateFile(){
        String path = "product.json";
        String content = gson.toJson(productList);
        FileUtils.coverFileContent(path,content);
    }
    private void updateDeleteFile(){
        String path = "deleteProduct.json";
        String content = gson.toJson(deletedProductList);
        FileUtils.coverFileContent(path,content);
    }
}
