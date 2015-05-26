package com.dealmoon.dao;

import java.util.List;

import com.dealmoon.model.UserDeleteCommentCount;

public interface PostCommentMapper {

	//用户被删除评论的数量
	List<UserDeleteCommentCount> selectDeleteCommentCountByUser();
}