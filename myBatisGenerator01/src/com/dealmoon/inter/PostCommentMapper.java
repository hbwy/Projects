package com.dealmoon.inter;

import com.dealmoon.model.PostComment;

public interface PostCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PostComment record);

    int insertSelective(PostComment record);

    PostComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PostComment record);

    int updateByPrimaryKeyWithBLOBs(PostComment record);

    int updateByPrimaryKey(PostComment record);
}