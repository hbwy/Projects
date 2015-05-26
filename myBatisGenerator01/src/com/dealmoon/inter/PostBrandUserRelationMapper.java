package com.dealmoon.inter;

import com.dealmoon.model.PostBrandUserRelation;

public interface PostBrandUserRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PostBrandUserRelation record);

    int insertSelective(PostBrandUserRelation record);

    PostBrandUserRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PostBrandUserRelation record);

    int updateByPrimaryKey(PostBrandUserRelation record);
}