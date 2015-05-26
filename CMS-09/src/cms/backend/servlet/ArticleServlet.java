package cms.backend.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.backend.dao.ArticleDao;
import cms.backend.dao.ChannelDao;
import cms.model.Article;
import cms.model.Attachment;
import cms.utils.RequestUtil;
import cms.utils.SystemContext;

public class ArticleServlet extends BaseServlet {

	private ArticleDao articleDao;
	private ChannelDao channelDao;
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	public void setChannelDao(ChannelDao channelDao) {
		this.channelDao = channelDao;
	}

	// left.jsp添加，添加文章前先提交到此方法，读取频道
	public void addInput(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("channels", channelDao.query());
		request.getRequestDispatcher("/backend/article/add_article.jsp")
				.forward(request, response);
	}

	// 添加
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Article a = (Article)RequestUtil.copyParam(Article.class, request);
		Attachment[] attachments = (Attachment[])request.getParameterMap().get("attachs");
		if(attachments != null){
			for (Attachment attachment : attachments) {
				a.addAttachment(attachment);
			}
		}
		articleDao.save(a);
		request.getRequestDispatcher("/backend/article/add_article_success.jsp")
				.forward(request, response);
	}

	// 编辑
	public void modifyInput(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("channels", channelDao.query()); // 获得频道信息
		int id = Integer.parseInt(request.getParameter("id"));
		Article a = articleDao.get(id);
		request.setAttribute("article", a);
		request.getRequestDispatcher("/backend/article/update_input.jsp").forward(request, response);
	}

	// 提交修改
	public void modify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Article a = (Article)RequestUtil.copyParam(Article.class, request);
		articleDao.update(a);

		// 修改成功，跳转到修改成功页面
		// request.getRequestDispatcher("/backend/article/update_article_success.jsp").forward(request,
		// response);

		// 修改完成关闭窗口
		PrintWriter out = response.getWriter();
		out.println("<script language='javascript'>window.close()</script>");
		out.close();
	}

	// 发布
	public void pub(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		articleDao.publish(id);
		request.getRequestDispatcher("/backend/ArticleServlet?m=list").forward(
				request, response);
	}

	// 批量发布
	public void pubBatch(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameterValues("checkItem") != null) {
			String checkItems[] = request.getParameterValues("checkItem"); // 此时复选框的value就是article_id
			for (int i = 0; i < checkItems.length; i++) { // 实质就是循环删除
				articleDao.publish(Integer.parseInt(checkItems[i]));
			}
		}
		request.getRequestDispatcher("/backend/ArticleServlet?m=list").forward(
				request, response);
	}

	// 删除
	public void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null) {
			request.setAttribute("error", "文章ID不能为空");
			// 如果ID为空，转到出错页面
			request.getRequestDispatcher("/backend/common/error.jsp").forward(
					request, response);
		} else {
			articleDao.delete(Integer.parseInt(id));
			request.getRequestDispatcher("/backend/ArticleServlet?m=list")
					.forward(request, response);
		}
	}

	// 批量删除
	public void delBatch(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameterValues("checkItem") != null) {
			String checkItems[] = request.getParameterValues("checkItem"); // 此时复选框的value就是article_id
			for (int i = 0; i < checkItems.length; i++) { // 实质就是循环删除
				articleDao.delete(Integer.parseInt(checkItems[i]));
			}
		}
		request.getRequestDispatcher("/backend/ArticleServlet?m=list").forward(
				request, response);
	}

	// 多查
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String titleKey = request.getParameter("titleKey"); // 取得搜索关键字
		if (titleKey == null) {
			titleKey = "";
		}
		// 返回集合
		request.setAttribute("articles", articleDao.query(titleKey));

		// 此后pm已经有了所有的分页参数，此时pm已经取得了记录总数
		request.setAttribute("pageModel",SystemContext.getPM());
		request.getRequestDispatcher("/backend/article/article_list.jsp")
				.forward(request, response);
	}
}
