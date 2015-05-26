package com.dealmoon.utils;

import org.apache.ibatis.session.SqlSession;

import com.dealmoon.utils.DataSource.DataSourceEnvironment;

public class DB {

	public static SqlSession openSessionUGC() {
		return DataSource.getSqlSessionFactory(DataSourceEnvironment.UGC).openSession();
	}

	public static SqlSession openSessionDM() {
		return DataSource.getSqlSessionFactory(DataSourceEnvironment.DM_UCENTER).openSession();
	}

}
