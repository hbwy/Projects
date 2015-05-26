package cms.backend.dao.impl;

import org.apache.ibatis.session.SqlSession;

import cms.backend.dao.UserDao;
import cms.model.User;
import cms.utils.IDB;

public class UserDaoForIBatisImpl implements UserDao {

	//��¼��֤
	public boolean login(String username, String password, String checkcode,
			String sessioncodes) {
		// �ȼ����֤���Ƿ���ȷ���ڼ���û���������
		// ������
		checkcode = sessioncodes;

		if (checkcode.equals("")) {
			throw new RuntimeException("��֤�벻��Ϊ��");
		} else if (!sessioncodes.equalsIgnoreCase(checkcode)) {
			throw new RuntimeException("��֤�벻��ȷ");
		} else {
			User user = this.getByUsername(username); // ���ò�ѯ����
			if (user != null) { // ȷ����û�鵽
				if (password.equals(user.getPassword())) {
					return true;
				} else {
					throw new RuntimeException("���벻��ȷ");// ���Ò��쳣����ʽ���ش�����Ϣ,
														// �����뷵��ֵ���ͳ�ͻ���ȷ���״̬�롢�ַ�����
				}
			} else {
				throw new RuntimeException("�û���������");
			}
		}
	}

	//�����û��������û�
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

	//ע��
	public void add(User user) {
		// ��Session
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
