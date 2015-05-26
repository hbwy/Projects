package com.dealmoon.inter;

import com.dealmoon.model.BrandFavorite;

public interface BrandFavoriteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BrandFavorite record);

    int insertSelective(BrandFavorite record);

    BrandFavorite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BrandFavorite record);

    int updateByPrimaryKey(BrandFavorite record);
}