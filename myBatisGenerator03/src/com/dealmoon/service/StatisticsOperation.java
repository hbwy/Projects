package com.dealmoon.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dealmoon.dao.StatisticsMapper;
import com.dealmoon.model.PostCountInBrand;
import com.dealmoon.model.Statistics;
import com.dealmoon.utils.DB;

public class StatisticsOperation {

	public void insertBrandInfo() {
		SqlSession session = DB.openSessionUGC();
		StatisticsMapper StatisticsMapper = session.getMapper(StatisticsMapper.class);
		List<PostCountInBrand> pcibs = BrandOperation.selectPostCountInBrand(session);
		PostCountInBrand pcib;
		Statistics s = null;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date date = calendar.getTime();
		
		for (int i = 0; i < pcibs.size(); i++) {
			pcib = new PostCountInBrand();
			s = new Statistics();

			pcib = pcibs.get(i);
			s.setDate(date);
			s.setResId(pcib.getBrandId());
			s.setResType("brand");
			s.setType1("post_brand_num");
			s.setData1(pcib.getPostCount());
			StatisticsMapper.insert(s);
			session.commit();
		}
		session.close();
	}

	public static void main(String[] args) {
		StatisticsOperation so = new StatisticsOperation();
		so.insertBrandInfo();
	}
}
