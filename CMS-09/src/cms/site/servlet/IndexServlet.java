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

	// 标题栏
	public void nav(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("channels", channelDao.query());
		request.getRequestDispatcher("/site/nav.jsp")
				.include(request, response);// 如果采用动态包含使用include
	}

	// 首页查询某个频道的文章
	public void channelIndex(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String channelId = request.getParameter("channelId");

		List<Article> articles = (List<Article>) articleDao.query("",
				channelId, false, false, false);
		request.setAttribute("channel", channelDao.get(channelId));
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("/site/channelIndex.jsp").include(request,
				response);// 如果采用动态包含使用include

	}

	// 头条
	public void headline(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Article> articles = (List<Article>) articleDao.query("", "", true,
				false, false);
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("/site/headline.jsp").include(request,
				response);// 如果采用动态包含使用include

	}

	// 推荐阅读
	public void recommend(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Article> articles = (List<Article>) articleDao.query("", "",
				false, true, false);
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("/site/recommend.jsp").include(request,
				response);// 如果采用动态包含使用include

	}

	// 最新发表
	public void publish(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Article> articles = (List<Article>) articleDao.query("", "",
				false, false, true);

		request.setAttribute("articles", articles);
		request.getRequestDispatcher("/site/publish.jsp").include(request,
				response);// 如果采用动态包含使用include

	}

	// 相关文章
	public void related(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		List<Article> articles = (List<Article>) articleDao.related(articleId);

		request.setAttribute("articles", articles);
		request.getRequestDispatcher("/site/related.jsp").include(request,
				response);// 如果采用动态包含使用include

	}

	// 频道具体内容
	public void topic(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String channelId = request.getParameter("channelId");
		List<Article> articles = (List<Article>) articleDao.query("",
				channelId, false, false, false);
		request.setAttribute("pagemodel", SystemContext.getPM());
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("/site/topic_list.jsp").include(request,
				response);// 如果采用动态包含使用include

	}

	// 文章具体内容
	public void article(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("articleId"));
		// 更新点击量
		updateClick(request, response);
		request.setAttribute("article", articleDao.get(id));
		request.getRequestDispatcher("/site/article_detail.jsp").include(
				request, response);// 如果采用动态包含使用include

	}

	// 更新文章点击量
	public void updateClick(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		//从ServletContext中取出一个Map,ServletContext范围是整个web应用
		Map visitors = (Map) getServletContext().getAttribute("visitors");
		if (visitors == null) {
			visitors = new ConcurrentHashMap();
			getServletContext().setAttribute("visitors", visitors);
		}
		// 得到客户端IP地址
		String clickIp = request.getRemoteAddr();
		// 以文章ID和用户IP为键
		String key = articleId + "_" + clickIp;
		Date lastVisitTime = (Date) visitors.get(key);
		// 没有访问记录、或最后一次访问在一个小时之前，需再次记录访问量
		// 否则，无需再次记录访问量
		if (lastVisitTime == null || !withinOneHour(lastVisitTime)) {
			// 每次访问文章具体内容调用此方法使点击量加1同步到数据库
			articleDao.updateClickScore(articleId);
			visitors.put(key, new Date());
		}
	}

	// 将lastVisitTime和现在的时间相比，判断其是否在一个小时之内
	private boolean withinOneHour(Date lastVisitTime) {
		// 现在的时间
		Calendar now = Calendar.getInstance();

		// 上次访问时间
		Calendar last = Calendar.getInstance();
		last.setTime(lastVisitTime);

		last.add(Calendar.HOUR_OF_DAY, 1);
		// before(),判断此 Calendar 表示的时间是否在指定 Object 表示的时间之前
		if (last.before(now)) {
			return false;
		}
		return true;
	}

}
