package com.dealmoon.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dealmoon.dao.FollowListMapper;
import com.dealmoon.dao.PostMapper;
import com.dealmoon.model.UserDeletePostCount;
import com.dealmoon.model.UserFollowCount;
import com.dealmoon.model.UserPostCount;
import com.dealmoon.model.UserRecommendPostCount;
import com.dealmoon.utils.DB;

public class UserOperation {

	//	    Date endTime = new Date();
	//		Calendar calendar = Calendar.getInstance();
	//		calendar.setTime(endTime);
	//		calendar.add(Calendar.DAY_OF_MONTH, -1);
	//		Date startTime = calendar.getTime();
	//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
	//
	//		String s_startTime = sdf.format(startTime);
	//		String s_endTime = sdf.format(endTime);
	//

	/**
	 * 用户晒单数量
	 */
	public void selectPostCountByUser() {
		SqlSession session = DB.openSession();
		PostMapper postMapper = session.getMapper(PostMapper.class);
		Map<String, String> map = new HashMap<String, String>();

		String s_startTime = "2015-4-10 00:00:00";
		String s_endTime = "2015-5-10 00:00:00";

		map.put("startTime", s_startTime);
		map.put("endTime", s_endTime);

		List<UserPostCount> upcs = postMapper.selectPostCountByUser(map);
		for (UserPostCount userPostCount : upcs) {
			System.out.println(userPostCount.getUserId() + ":" + userPostCount.getPostCount());
		}
	}

	/**
	 * 关注用户数量
	 */
	public void selectFollowCountByUser() {
		SqlSession session = DB.openSession();
		FollowListMapper followListMapper = session.getMapper(FollowListMapper.class);
		Map<String, String> map = new HashMap<String, String>();

		String s_startTime = "2015-4-10 00:00:00";
		String s_endTime = "2015-5-10 00:00:00";

		map.put("startTime", s_startTime);
		map.put("endTime", s_endTime);

		List<UserFollowCount> ufcs = followListMapper.selectFollowCountByUser(map);
		for (UserFollowCount UserFollowCount : ufcs) {
			System.out.println(UserFollowCount.getUserId() + ":" + UserFollowCount.getFollowCount());
		}
	}

	/**
	 * 用户精华帖数量
	 */
	public void selectRecommendPostCountByUser() {
		SqlSession session = DB.openSession();
		PostMapper postMapper = session.getMapper(PostMapper.class);
		Map<String, String> map = new HashMap<String, String>();

		String s_startTime = "2015-4-10 00:00:00";
		String s_endTime = "2015-5-18 00:00:00";

		map.put("startTime", s_startTime);
		map.put("endTime", s_endTime);

		List<UserRecommendPostCount> urpcs = postMapper.selectRecommendPostCountByUser(map);
		for (UserRecommendPostCount userRecommendPostCount : urpcs) {
			System.out.println(userRecommendPostCount.getUserId() + ":"
					+ userRecommendPostCount.getRecommendPostCount());
		}
	}

	/**
	 * 用户晒出晒单的数量
	 */
	public void selectDeletePostCountByUser() {
		SqlSession session = DB.openSession();
		PostMapper postMapper = session.getMapper(PostMapper.class);
		Map<String, String> map = new HashMap<String, String>();

		String s_startTime = "2015-4-10 00:00:00";
		String s_endTime = "2015-5-18 00:00:00";

		map.put("startTime", s_startTime);
		map.put("endTime", s_endTime);

		List<UserDeletePostCount> urpcs = postMapper.selectDeletePostCountByUser(map);
		for (UserDeletePostCount userDeletePostCount : urpcs) {
			System.out.println(userDeletePostCount.getUserId() + ":" + userDeletePostCount.getDeletePostCount());
		}
	}

	public static void main(String[] args) {
		UserOperation u = new UserOperation();
		u.selectDeletePostCountByUser();
	}
}
