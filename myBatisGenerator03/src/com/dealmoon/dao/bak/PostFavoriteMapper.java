package com.dealmoon.dao.bak;

import com.dealmoon.model.bak.PostFavorite;

public interface PostFavoriteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PostFavorite record);

    int insertSelective(PostFavorite record);

    PostFavorite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PostFavorite record);

    int updateByPrimaryKey(PostFavorite record);
}