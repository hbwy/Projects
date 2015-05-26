package com.dealmoon.dao;

import java.util.List;
import java.util.Map;

import com.dealmoon.model.UserFollowCount;

public interface FollowListMapper {
    List<UserFollowCount> selectFollowCountByUser(Map<String,String> map);
}