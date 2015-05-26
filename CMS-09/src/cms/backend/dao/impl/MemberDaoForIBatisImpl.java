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

	//添加会员
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

	//删除会员
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

	//更新
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

	//修改密码
	public void updatePassword(int memberId, String oldPass, String newPass) {
		//验证旧密码,验证通过修改密码
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
			//验证不通过抛出异常
			throw new RuntimeException("旧密码不正确");
		}
	}
	
	//单查，根据ID查会员
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

	//单查，根据昵称查会员
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

	//多查
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
