package com.dealmoon.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dealmoon.dao.PostBrandUserRelationMapper;
import com.dealmoon.model.PostCountInBrand;
import com.dealmoon.utils.DB;

public class BrandOperation {

	public static List<PostCountInBrand> selectPostCountInBrand(SqlSession session) {
		List<PostCountInBrand> pcbs;
		PostBrandUserRelationMapper PostBrandUserRelationMapper = session.getMapper(PostBrandUserRelationMapper.class);
		Map<String, String> map = new HashMap<String, String>();

//		Date endTime = new Date();

//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(endTime);
//		calendar.add(Calendar.DAY_OF_MONTH, -1);
//		Date startTime = calendar.getTime();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
//
//		String s_startTime = sdf.format(startTime);
//		String s_endTime = sdf.format(endTime);
//
		String s_startTime = "2015-4-10 00:00:00";
		String s_endTime = "2015-5-10 00:00:00";

		map.put("startTime", s_startTime);
		map.put("endTime", s_endTime);

		pcbs = PostBrandUserRelationMapper.selectPostCountInBrand(map);
		return pcbs;
	}
}