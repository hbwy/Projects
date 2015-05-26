package com.dealmoon.dao;

import com.dealmoon.model.Statistics;

public interface StatisticsMapper {
    int deleteByPrimaryKey(Integer id);
    
    int insert(Statistics record);

    int insertSelective(Statistics record);

    Statistics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Statistics record);

    int updateByPrimaryKey(Statistics record);
}