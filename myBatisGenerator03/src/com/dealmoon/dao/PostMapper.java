package com.dealmoon.dao;

import java.util.List;
import java.util.Map;

import com.dealmoon.model.UserDeletePostCount;
import com.dealmoon.model.UserPostCount;
import com.dealmoon.model.UserRecommendPostCount;

public interface PostMapper {
	//查用户发的晒单的数量
	List<UserPostCount> selectPostCountByUser(Map<String, String> map);

	//查用户精华帖的数量
	List<UserRecommendPostCount> selectRecommendPostCountByUser(Map<String, String> map);

	//查询用户删除晒单的数量
	List<UserDeletePostCount> selectDeletePostCountByUser(Map<String, String> map);
}