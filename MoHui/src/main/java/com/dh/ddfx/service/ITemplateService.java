package com.dh.ddfx.service;

import com.dh.ddfx.model.entity.api.ApiEntity;
import com.dh.ddfx.model.response.house.HouseVideoRealtimeListResponse;

import java.util.List;

public interface ITemplateService {

    /**
     * 测试服务调用
     * @return
     */
    HouseVideoRealtimeListResponse testService();

    /**
     * 从mysql获取数据
     * @return
     */
    List<ApiEntity> testMybatis();
}
