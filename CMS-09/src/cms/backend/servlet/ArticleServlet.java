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

	// left.jsp��ӣ��������ǰ���ύ���˷�������ȡƵ��
	public void addInput(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("channels", channelDao.query());
		request.getRequestDispatcher("/backend/article/add_article.jsp")
				.forward(request, response);
	}

	// ���
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

	// �༭
	public void modifyInput(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("channels", channelDao.query()); // ���Ƶ����Ϣ
		int id = Integer.parseInt(request.getParameter("id"));
		Article a = articleDao.get(id);
		request.setAttribute("article", a);
		request.getRequestDispatcher("/backend/article/update_input.jsp").forward(request, response);
	}

	// �ύ�޸�
	public void modify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Article a = (Article)RequestUtil.copyParam(Article.class, request);
		articleDao.update(a);

		// �޸ĳɹ�����ת���޸ĳɹ�ҳ��
		// request.getRequestDispatcher("/backend/article/update_article_success.jsp").forward(request,
		// response);

		// �޸���ɹرմ���
		PrintWriter out = response.getWriter();
		out.println("<script language='javascript'>window.close()</script>");
		out.close();
	}

	// ����
	public void pub(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		articleDao.publish(id);
		request.getRequestDispatcher("/backend/ArticleServlet?m=list").forward(
				request, response);
	}

	// ��������
	public void pubBatch(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameterValues("checkItem") != null) {
			String checkItems[] = request.getParameterValues("checkItem"); // ��ʱ��ѡ���value����article_id
			for (int i = 0; i < checkItems.length; i++) { // ʵ�ʾ���ѭ��ɾ��
				articleDao.publish(Integer.parseInt(checkItems[i]));
			}
		}
		request.getRequestDispatcher("/backend/ArticleServlet?m=list").forward(
				request, response);
	}

	// ɾ��
	public void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null) {
			request.setAttribute("error", "����ID����Ϊ��");
			// ���IDΪ�գ�ת������ҳ��
			request.getRequestDispatcher("/backend/common/error.jsp").forward(
					request, response);
		} else {
			articleDao.delete(Integer.parseInt(id));
			request.getRequestDispatcher("/backend/ArticleServlet?m=list")
					.forward(request, response);
		}
	}

	// ����ɾ��
	public void delBatch(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameterValues("checkItem") != null) {
			String checkItems[] = request.getParameterValues("checkItem"); // ��ʱ��ѡ���value����article_id
			for (int i = 0; i < checkItems.length; i++) { // ʵ�ʾ���ѭ��ɾ��
				articleDao.delete(Integer.parseInt(checkItems[i]));
			}
		}
		request.getRequestDispatcher("/backend/ArticleServlet?m=list").forward(
				request, response);
	}

	// ���
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String titleKey = request.getParameter("titleKey"); // ȡ�������ؼ���
		if (titleKey == null) {
			titleKey = "";
		}
		// ���ؼ���
		request.setAttribute("articles", articleDao.query(titleKey));

		// �˺�pm�Ѿ��������еķ�ҳ��������ʱpm�Ѿ�ȡ���˼�¼����
		request.setAttribute("pageModel",SystemContext.getPM());
		request.getRequestDispatcher("/backend/article/article_list.jsp")
				.forward(request, response);
	}
}
