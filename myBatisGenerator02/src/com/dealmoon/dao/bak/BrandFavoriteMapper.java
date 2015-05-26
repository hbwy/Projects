package com.dealmoon.dao.bak;

import com.dealmoon.model.bak.BrandFavorite;

public interface BrandFavoriteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BrandFavorite record);

    int insertSelective(BrandFavorite record);

    BrandFavorite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BrandFavorite record);

    int updateByPrimaryKey(BrandFavorite record);
}