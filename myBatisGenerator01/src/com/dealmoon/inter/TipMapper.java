package com.dealmoon.inter;

import com.dealmoon.model.Tip;

public interface TipMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tip record);

    int insertSelective(Tip record);

    Tip selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tip record);

    int updateByPrimaryKey(Tip record);
}