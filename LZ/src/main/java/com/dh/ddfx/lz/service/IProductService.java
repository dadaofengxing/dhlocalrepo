package com.dh.ddfx.lz.service;

import com.dh.ddfx.lz.module.Product;
import com.dh.ddfx.lz.module.request.PageCommonRequest;
import com.dh.ddfx.lz.module.request.ProductUpdateRequest;
import com.dh.ddfx.lz.module.response.PageModel;
import com.dh.ddfx.lz.module.response.ResponseCommonModel;

public interface IProductService {
    PageModel<Product> list(PageCommonRequest request);

    ResponseCommonModel add(Product request);

    ResponseCommonModel delete(String id);

    ResponseCommonModel update(ProductUpdateRequest request);
}
