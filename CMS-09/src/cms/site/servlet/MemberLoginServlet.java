package cms.site.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.backend.dao.MemberDao;
import cms.backend.servlet.BaseServlet;
import cms.model.Member;
import cms.utils.RequestUtil;

public class MemberLoginServlet extends BaseServlet {

	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	// 登录
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		// 昵称不能为空
		if (nickname == null || nickname.equals("")) {
			request.setAttribute("error", "用户【" + nickname + "】不能为空");
			request.getRequestDispatcher("/backend/common/error.jsp").forward(
					request, response);
			return;
		}
		// 密码不能为空
		if (password == null || password.equals("")) {
			request.setAttribute("error", "用户【" + nickname + "】密码不能为空");
			request.getRequestDispatcher("/backend/common/error.jsp").forward(
					request, response);
			return;
		}

		Member member = memberDao.findMemberByNickname(nickname);
		// 用户是否存在
		if (member != null) {
			// 如果存在，密码是否正确
			if (member.getPassword().equals(password)) {
				request.getSession().setAttribute("LOGIN_MEMBER", member);
				// 跳转到原请求页面
				String ref = request.getHeader("referer");
				response.sendRedirect(ref);
			} else {
				request.setAttribute("error", "用户【" + nickname + "】密码不正确");
				request.getRequestDispatcher("/backend/common/error.jsp")
						.forward(request, response);
				return;
			}
		} else {
			request.setAttribute("error", "用户【" + nickname + "】不存在");
			request.getRequestDispatcher("/backend/common/error.jsp").forward(
					request, response);
			return;
		}
	}

	// 登出
	public void loginOut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		// 跳转到原请求页面
		String ref = request.getHeader("referer");
		response.sendRedirect(ref);
	}
}
