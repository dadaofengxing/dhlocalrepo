package com.dh.ddfx.service.impl;

import com.dh.ddfx.dao.ITemplateDao;
import com.dh.ddfx.model.entity.api.ApiEntity;
import com.dh.ddfx.model.response.house.HouseVideoRealtimeListResponse;
import com.dh.ddfx.service.ITemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duh on 2018/6/13 15:53.
 * Email:duh@elab-plus.com
 * Version:v1.0
 */
@Service("templateService")
public class TemplateServiceImpl implements ITemplateService {
    @Autowired
    ITemplateDao templateDao;

    @Override
    public HouseVideoRealtimeListResponse testService() {
        HouseVideoRealtimeListResponse response = new HouseVideoRealtimeListResponse();
        response.init();
        return response;
    }

    /**
     * 从mysql获取数据
     * @return
     */
    @Override
    public List<ApiEntity> testMybatis() {
        return templateDao.getResponseList();
    }
}
