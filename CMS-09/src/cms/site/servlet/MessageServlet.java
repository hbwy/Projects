package cms.site.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.backend.dao.ArticleDao;
import cms.backend.dao.MessageDao;
import cms.backend.servlet.BaseServlet;
import cms.model.Message;
import cms.model.PageModel;
import cms.utils.SystemContext;

public class MessageServlet extends BaseServlet {

	private ArticleDao articleDao;
	private MessageDao messageDao;
	
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	// 添加留言
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Message m = new Message();
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		articleDao.updateMsgCount(articleId);
		m.setArticleId(articleId);
		m.setContent(request.getParameter("content"));
		String publisher = request.getParameter("publisher");
		if (publisher == null) {
			publisher = request.getRemoteAddr();
		}
		m.setPublisher(publisher);
		this.messageDao.save(m);
		response.sendRedirect(request.getContextPath()
				+ "/article.jsp?articleId=" + articleId);
	}

	// 查询文章列表
	public void articlelist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String titleKey = request.getParameter("titleKey");
		if (titleKey == null) {
			titleKey = "";
		}
		request.setAttribute("articles", this.articleDao.query(titleKey));
		request.setAttribute("pageModel",SystemContext.getPM());
		request.getRequestDispatcher("/backend/article/article_title_list.jsp")
				.forward(request, response);
	}

	// 前台查询留言
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		request.setAttribute("messages", this.messageDao.query(articleId));
		request.setAttribute("pageModel", SystemContext.getPM());
		request.getRequestDispatcher("/site/message_list.jsp").include(request,
				response);
	}

	// 后台查询留言
	public void backendlist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		request.setAttribute("messages", this.messageDao.query(articleId));
		request.setAttribute("pageModel",SystemContext.getPM());
		request.getRequestDispatcher(
				"/backend/article/message_list.jsp?articleId=" + articleId)
				.forward(request, response);
	}

	// 删除留言
	public void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		this.messageDao.delete(id);
		request.getRequestDispatcher(
				"/site/MessageServlet?m=backendlist&articleId=" + articleId)
				.forward(request, response);
	}

}
