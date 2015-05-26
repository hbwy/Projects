package cms.backend.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.backend.dao.UserDao;

public class LoginServlet extends BaseServlet {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
    
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkcode = request.getParameter("checkcode");
		String sessioncodes = (String) request.getSession().getAttribute(
				"codes"); // 取得session里的验证码

		boolean flag = false;
		try {
			flag = userDao.login(username, password, checkcode, sessioncodes); // 调用login方法验证
		} catch (RuntimeException e) {
			request.setAttribute("error", e.getMessage());
		}
		if (flag) {
			request.getSession().setAttribute("LOGIN_USERNAME", username); // 登录验证成功，把用户信息存到session里
			response.sendRedirect(request.getContextPath()
					+ "/backend/main.jsp");
		} else {
			request.getRequestDispatcher("/backend/login.jsp").forward(request,
					response);
			// response.sendRedirect(request.getContextPath()+"/backend/login.jsp?username="+username);
		}
	}
	
	public void loginOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.getSession().removeAttribute("LOGIN_USERNAME");//清除指定的session
        request.getSession().invalidate();//设置session无效，相当于清除所有的session
        response.sendRedirect(request.getContextPath()+"/backend/login.jsp");
	}
}
