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

	// ��¼
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		// �ǳƲ���Ϊ��
		if (nickname == null || nickname.equals("")) {
			request.setAttribute("error", "�û���" + nickname + "������Ϊ��");
			request.getRequestDispatcher("/backend/common/error.jsp").forward(
					request, response);
			return;
		}
		// ���벻��Ϊ��
		if (password == null || password.equals("")) {
			request.setAttribute("error", "�û���" + nickname + "�����벻��Ϊ��");
			request.getRequestDispatcher("/backend/common/error.jsp").forward(
					request, response);
			return;
		}

		Member member = memberDao.findMemberByNickname(nickname);
		// �û��Ƿ����
		if (member != null) {
			// ������ڣ������Ƿ���ȷ
			if (member.getPassword().equals(password)) {
				request.getSession().setAttribute("LOGIN_MEMBER", member);
				// ��ת��ԭ����ҳ��
				String ref = request.getHeader("referer");
				response.sendRedirect(ref);
			} else {
				request.setAttribute("error", "�û���" + nickname + "�����벻��ȷ");
				request.getRequestDispatcher("/backend/common/error.jsp")
						.forward(request, response);
				return;
			}
		} else {
			request.setAttribute("error", "�û���" + nickname + "��������");
			request.getRequestDispatcher("/backend/common/error.jsp").forward(
					request, response);
			return;
		}
	}

	// �ǳ�
	public void loginOut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		// ��ת��ԭ����ҳ��
		String ref = request.getHeader("referer");
		response.sendRedirect(ref);
	}
}
