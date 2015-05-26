package com.dealmoon.inter;

import com.dealmoon.model.PostFavorite;

public interface PostFavoriteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PostFavorite record);

    int insertSelective(PostFavorite record);

    PostFavorite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PostFavorite record);

    int updateByPrimaryKey(PostFavorite record);
}