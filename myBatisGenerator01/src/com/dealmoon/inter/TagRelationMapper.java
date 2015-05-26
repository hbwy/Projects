package com.dealmoon.inter;

import com.dealmoon.model.TagRelation;

public interface TagRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TagRelation record);

    int insertSelective(TagRelation record);

    TagRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TagRelation record);

    int updateByPrimaryKey(TagRelation record);
}