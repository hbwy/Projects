package cms.backend.dao;

import java.util.List;

import cms.model.Member;

public interface MemberDao {
	void add(Member m);
	void del(int id);
	void update(Member m);
	void updatePassword(int memberId,String oldPass,String newPass);
	Member findMemberById(int id);
	Member findMemberByNickname(String nickname);
	List<Member> findAll();
}
