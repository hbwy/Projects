package cms.site.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.backend.dao.ArticleDao;
import cms.backend.dao.ChannelDao;
import cms.backend.servlet.BaseServlet;
import cms.model.Article;
import cms.utils.SystemContext;

public class IndexServlet extends BaseServlet {

	private ArticleDao articleDao;
	private ChannelDao channelDao;

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	public void setChannelDao(ChannelDao channelDao) {
		this.channelDao = channelDao;
	}

	// ������
	public void nav(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("channels", channelDao.query());
		request.getRequestDispatcher("/site/nav.jsp")
				.include(request, response);// ������ö�̬����ʹ��include
	}

	// ��ҳ��ѯĳ��Ƶ��������
	public void channelIndex(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String channelId = request.getParameter("channelId");

		List<Article> articles = (List<Article>) articleDao.query("",
				channelId, false, false, false);
		request.setAttribute("channel", channelDao.get(channelId));
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("/site/channelIndex.jsp").include(request,
				response);// ������ö�̬����ʹ��include

	}

	// ͷ��
	public void headline(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Article> articles = (List<Article>) articleDao.query("", "", true,
				false, false);
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("/site/headline.jsp").include(request,
				response);// ������ö�̬����ʹ��include

	}

	// �Ƽ��Ķ�
	public void recommend(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Article> articles = (List<Article>) articleDao.query("", "",
				false, true, false);
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("/site/recommend.jsp").include(request,
				response);// ������ö�̬����ʹ��include

	}

	// ���·���
	public void publish(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Article> articles = (List<Article>) articleDao.query("", "",
				false, false, true);

		request.setAttribute("articles", articles);
		request.getRequestDispatcher("/site/publish.jsp").include(request,
				response);// ������ö�̬����ʹ��include

	}

	// �������
	public void related(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		List<Article> articles = (List<Article>) articleDao.related(articleId);

		request.setAttribute("articles", articles);
		request.getRequestDispatcher("/site/related.jsp").include(request,
				response);// ������ö�̬����ʹ��include

	}

	// Ƶ����������
	public void topic(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String channelId = request.getParameter("channelId");
		List<Article> articles = (List<Article>) articleDao.query("",
				channelId, false, false, false);
		request.setAttribute("pagemodel", SystemContext.getPM());
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("/site/topic_list.jsp").include(request,
				response);// ������ö�̬����ʹ��include

	}

	// ���¾�������
	public void article(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("articleId"));
		// ���µ����
		updateClick(request, response);
		request.setAttribute("article", articleDao.get(id));
		request.getRequestDispatcher("/site/article_detail.jsp").include(
				request, response);// ������ö�̬����ʹ��include

	}

	// �������µ����
	public void updateClick(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		//��ServletContext��ȡ��һ��Map,ServletContext��Χ������webӦ��
		Map visitors = (Map) getServletContext().getAttribute("visitors");
		if (visitors == null) {
			visitors = new ConcurrentHashMap();
			getServletContext().setAttribute("visitors", visitors);
		}
		// �õ��ͻ���IP��ַ
		String clickIp = request.getRemoteAddr();
		// ������ID���û�IPΪ��
		String key = articleId + "_" + clickIp;
		Date lastVisitTime = (Date) visitors.get(key);
		// û�з��ʼ�¼�������һ�η�����һ��Сʱ֮ǰ�����ٴμ�¼������
		// ���������ٴμ�¼������
		if (lastVisitTime == null || !withinOneHour(lastVisitTime)) {
			// ÿ�η������¾������ݵ��ô˷���ʹ�������1ͬ�������ݿ�
			articleDao.updateClickScore(articleId);
			visitors.put(key, new Date());
		}
	}

	// ��lastVisitTime�����ڵ�ʱ����ȣ��ж����Ƿ���һ��Сʱ֮��
	private boolean withinOneHour(Date lastVisitTime) {
		// ���ڵ�ʱ��
		Calendar now = Calendar.getInstance();

		// �ϴη���ʱ��
		Calendar last = Calendar.getInstance();
		last.setTime(lastVisitTime);

		last.add(Calendar.HOUR_OF_DAY, 1);
		// before(),�жϴ� Calendar ��ʾ��ʱ���Ƿ���ָ�� Object ��ʾ��ʱ��֮ǰ
		if (last.before(now)) {
			return false;
		}
		return true;
	}

}
