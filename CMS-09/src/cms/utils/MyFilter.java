package cms.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter {

	String filterPattern;
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) 
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String requestUrl = req.getRequestURI().substring(req.getContextPath().length());
		String sessionCodes = (String)req.getSession().getAttribute("LOGIN_USERNAME");
		if(requestUrl.matches(filterPattern)){
			if(sessionCodes == null && requestUrl.equals("/backend/MemberServlet?m=register")&&!requestUrl.equals("/backend/LoginServlet")&& !requestUrl.equals("/backend/login.jsp")){
				res.sendRedirect(req.getContextPath()+"/backend/login.jsp");
				return;
			}
		}
		chain.doFilter(request, response);
	}
	public void init(FilterConfig config) throws ServletException {
		filterPattern = config.getInitParameter("filterPattern");
	}

}
