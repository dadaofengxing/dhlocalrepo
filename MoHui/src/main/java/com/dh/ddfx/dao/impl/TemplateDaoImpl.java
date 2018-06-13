package com.dh.ddfx.dao.impl;

import com.dh.ddfx.dao.ITemplateDao;
import com.dh.ddfx.model.entity.house.HouseInfoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author duh on 2018/6/13 17:16.
 * Email:duh@elab-plus.com
 * Version:v1.0
 */
@Repository("templateDao")
public class TemplateDaoImpl implements ITemplateDao {
    @Override
    public List<HouseInfoEntity> getResponseList() {
        System.out.println("begin to getResponseList...");
        return null;
    }
}
