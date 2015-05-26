package cms.backend.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cms.backend.dao.MemberDao;
import cms.model.Member;
import cms.utils.IDB;

public class MemberDaoForIBatisImpl implements MemberDao {

	//��ӻ�Ա
	public void add(Member m) {
		SqlSession session = IDB.getSession();
		try {
			session.insert(Member.class.getName()+".add", m);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	//ɾ����Ա
	public void del(int id) {
		SqlSession session = IDB.getSession();
		try {
			session.delete(Member.class.getName()+".del", id);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	//����
	public void update(Member m) {
		SqlSession session = IDB.getSession();
		try {
			session.update(Member.class.getName()+".update", m);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	//�޸�����
	public void updatePassword(int memberId, String oldPass, String newPass) {
		//��֤������,��֤ͨ���޸�����
		Member m = findMemberById(memberId);
		if(m.getPassword().equals(oldPass)){
			SqlSession session = IDB.getSession();
			Map params = new HashMap();
			params.put("memberId", memberId);
			params.put("newPass", newPass);
			try {
				session.update(Member.class.getName()+".updatePassword",params);
				session.commit();
			} catch (Exception e) {
				session.rollback();
				e.printStackTrace();
			}finally{
				session.close();
			}
		}else{
			//��֤��ͨ���׳��쳣
			throw new RuntimeException("�����벻��ȷ");
		}
	}
	
	//���飬����ID���Ա
	public Member findMemberById(int id) {
		SqlSession session = IDB.getSession();
		Member m = null;
		try {
			m = (Member)session.selectOne(Member.class.getName()+".findMemberById",id);
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return m;
	}

	//���飬�����ǳƲ��Ա
	public Member findMemberByNickname(String nickname) {
		SqlSession session = IDB.getSession();
		Member m = null;
		try {
			m = (Member)session.selectOne(Member.class.getName()+".findMemberByNickname",nickname);
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return m;
	}

	//���
	public List<Member> findAll() {
		SqlSession session = IDB.getSession();
		List<Member> members = new ArrayList<Member>();
		try {
			members = (List<Member>)session.selectList(Member.class.getName()+".findAll");
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return members;
	}

}
