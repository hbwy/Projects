package com.dealmoon.dao.bak;

import com.dealmoon.model.bak.TagRelation;

public interface TagRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TagRelation record);

    int insertSelective(TagRelation record);

    TagRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TagRelation record);

    int updateByPrimaryKey(TagRelation record);
}