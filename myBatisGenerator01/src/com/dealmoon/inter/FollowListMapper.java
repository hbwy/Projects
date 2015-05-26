package com.dealmoon.inter;

import com.dealmoon.model.FollowList;

public interface FollowListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FollowList record);

    int insertSelective(FollowList record);

    FollowList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FollowList record);

    int updateByPrimaryKey(FollowList record);
}