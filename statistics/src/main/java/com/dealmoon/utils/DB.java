package com.dealmoon.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import redis.clients.jedis.Jedis;

public class DB {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	private static Jedis jedis;

	static {
		try {
			reader = Resources.getResourceAsReader("config/configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static SqlSessionFactory getSessionFactory() {
		return sqlSessionFactory;
	}
	
	public static SqlSession openSession(){
		return sqlSessionFactory.openSession();
	}
	
	public static Jedis getJedis(){
		if(jedis == null){
			jedis = new Jedis("127.0.0.1", 6379);
		}
		return jedis;
	}
}
