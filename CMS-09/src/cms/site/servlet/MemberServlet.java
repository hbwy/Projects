package cms.site.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.backend.dao.MemberDao;
import cms.backend.servlet.BaseServlet;
import cms.model.Member;
import cms.utils.RequestUtil;

public class MemberServlet extends BaseServlet {

	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	// 注册
	public void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Member m = (Member) RequestUtil.copyParam(Member.class, request);
		memberDao.add(m);
		request.getSession().setAttribute("LOGIN_MEMBER", m);
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	// 根据id查会员
	public void get(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("member", memberDao.findMemberById(id));
		request.getRequestDispatcher("/member/member_index.jsp").forward(request, response);
	}

	// 修改会员信息
	public void modify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Member m = (Member) RequestUtil.copyParam(Member.class, request);
		memberDao.update(m);
		request.getSession().removeAttribute("LOGIN_MEMBER");
		request.getSession().setAttribute("LOGIN_MEMBER", m);
		request.getRequestDispatcher("/site/MemberServlet?m=get&"+m.getId()).forward(request, response);
	}

	// 修改密码
	public void updatePassword(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int memberId = Integer.parseInt(request.getParameter("id"));
		String oldPass = request.getParameter("oldPassword");
		String newPass = request.getParameter("newPassword");
		try {
			memberDao.updatePassword(memberId, oldPass, newPass);
			request.getSession().removeAttribute("LOGIN_MEMBER");
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		} catch (RuntimeException e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("/backend/common/error.jsp").forward(
					request, response);
			return;
		}
	}
}
