package cms.backend.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.backend.dao.MemberDao;
import cms.model.Member;

public class MemberAdminServlet extends BaseServlet {

	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	// 查询所有会员
	public void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Member> members = new ArrayList<Member>();
		members = memberDao.findAll();
		request.setAttribute("members", members);
		request.getRequestDispatcher("/backend/member/member_list.jsp").forward(request, response);
	}

	// 删除会员
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		memberDao.del(id);
		request.getRequestDispatcher("/backend/MemberAdminServlet?m=query").forward(request, response);
	}
}
