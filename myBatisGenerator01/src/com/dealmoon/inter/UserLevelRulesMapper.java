package com.dealmoon.inter;

import com.dealmoon.model.UserLevelRules;

public interface UserLevelRulesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserLevelRules record);

    int insertSelective(UserLevelRules record);

    UserLevelRules selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserLevelRules record);

    int updateByPrimaryKey(UserLevelRules record);
}