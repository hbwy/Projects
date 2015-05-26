package com.dealmoon.dao.bak;

import com.dealmoon.model.bak.PostComment;

public interface PostCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PostComment record);

    int insertSelective(PostComment record);

    PostComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PostComment record);

    int updateByPrimaryKeyWithBLOBs(PostComment record);

    int updateByPrimaryKey(PostComment record);
}