package com.dh.ddfx.dao;

import com.dh.ddfx.model.entity.house.HouseInfoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author DELL
 */
public interface ITemplateDao {
    /**
     * 获取列表
     * @return
     */
    List<HouseInfoEntity> getResponseList();
}
