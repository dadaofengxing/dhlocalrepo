package com.dh.ddfx.service.impl;

import com.dh.ddfx.model.response.house.HouseVideoRealtimeListResponse;
import com.dh.ddfx.service.ITemplateService;
import org.springframework.stereotype.Service;

/**
 * @author duh on 2018/6/13 15:53.
 * Email:duh@elab-plus.com
 * Version:v1.0
 */
@Service("templateService")
public class TemplateServiceImpl implements ITemplateService {
    @Override
    public HouseVideoRealtimeListResponse testService() {
        HouseVideoRealtimeListResponse response = new HouseVideoRealtimeListResponse();
        response.init();
        return response;
    }
}
