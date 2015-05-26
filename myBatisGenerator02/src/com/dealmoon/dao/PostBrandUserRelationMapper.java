package com.dealmoon.dao;

import java.util.List;
import java.util.Map;

import com.dealmoon.model.PostCountInBrand;

public interface PostBrandUserRelationMapper {
	
	List<PostCountInBrand> selectPostCountInBrand(Map<String,String> map);
}