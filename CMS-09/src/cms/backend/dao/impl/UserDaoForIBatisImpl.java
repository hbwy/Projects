package cms.backend.dao.impl;

import org.apache.ibatis.session.SqlSession;

import cms.backend.dao.UserDao;
import cms.model.User;
import cms.utils.IDB;

public class UserDaoForIBatisImpl implements UserDao {

	//登录验证
	public boolean login(String username, String password, String checkcode,
			String sessioncodes) {
		// 先检查验证码是否正确，在检查用户名和密码
		// 测试用
		checkcode = sessioncodes;

		if (checkcode.equals("")) {
			throw new RuntimeException("验证码不能为空");
		} else if (!sessioncodes.equalsIgnoreCase(checkcode)) {
			throw new RuntimeException("验证码不正确");
		} else {
			User user = this.getByUsername(username); // 调用查询方法
			if (user != null) { // 确保查没查到
				if (password.equals(user.getPassword())) {
					return true;
				} else {
					throw new RuntimeException("密码不正确");// 采用拋异常的形式返回错误信息,
														// 避免与返回值类型冲突，比返回状态码、字符串好
				}
			} else {
				throw new RuntimeException("用户名不存在");
			}
		}
	}

	//根据用户名查找用户
	private User getByUsername(String username) {
		SqlSession session = IDB.getSession();
		User user = null;
		try {
			user = (User) session.selectOne(User.class.getName()+".findByUserName", username);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	//注册
	public void add(User user) {
		// 打开Session
		SqlSession session = IDB.getSession();
		try {
			session.insert(User.class.getName() + ".add", user);
			session.commit();
		} catch (Exception e) {
			session.close();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
