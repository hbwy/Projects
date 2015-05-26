package com.dealmoon.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {

	private static final String CONFIGURATION_PATH = "config/configuration.xml";

	private static final Map<DataSourceEnvironment, SqlSessionFactory> SQLSESSIONFACTORYS = new HashMap<DataSourceEnvironment, SqlSessionFactory>();

	/**
	 * 根据指定的DataSourceEnvironment获取对应的SqlSessionFactory
	 * 
	 * @param environment 数据源environment
	 * @return SqlSessionFactory
	 */
	public static SqlSessionFactory getSqlSessionFactory(DataSourceEnvironment environment) {

		SqlSessionFactory sqlSessionFactory = SQLSESSIONFACTORYS.get(environment);
		if (sqlSessionFactory != null)
			return sqlSessionFactory;
		else {
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(CONFIGURATION_PATH);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, environment.name());

			} catch (IOException e) {
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			SQLSESSIONFACTORYS.put(environment, sqlSessionFactory);
			return sqlSessionFactory;
		}
	}

	/**
	 * 配置到Configuration.xml文件中的数据源的environment的枚举描述
	 */
	public static enum DataSourceEnvironment {
		UGC, DM_UCENTER;
	}
}
