package com.dh.ddfx.dao;

import com.dh.ddfx.model.entity.api.ApiEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author DELL
 */
@Repository
public interface ITemplateDao {
    /**
     * 获取列表
     * @return
     */
    List<ApiEntity> getResponseList();
}
