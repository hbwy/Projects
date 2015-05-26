package cms.backend.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cms.backend.dao.ChannelDao;
import cms.model.Channel;
import cms.utils.RequestUtil;

public class ChannelServlet extends BaseServlet {
	private ChannelDao channelDao;
	
	public void setChannelDao(ChannelDao channelDao) {
		this.channelDao = channelDao;
	}

	// 增加
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Channel c = (Channel)RequestUtil.copyParam(Channel.class, request);
		channelDao.save(c);  //调用ChannelDao的添加方法
		response.sendRedirect(request.getContextPath()
				+ "/backend/channel/add_channel_success.jsp");
	}

	// 修改
	public void modify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Channel c = (Channel)RequestUtil.copyParam(Channel.class, request);
		channelDao.update(c);//调用ChannelDao的更新方法
		//list(request, response); // 调用多查，显示修改后的结果
		request.getRequestDispatcher("/backend/ChannelServlet?m=list").forward(request, response);
	}

	// 删除
	public void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		channelDao.delete(id);
		request.getRequestDispatcher("/backend/ChannelServlet?m=list").forward(request, response);

	}

	// 多查
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Channel> channels = channelDao.query();
		request.setAttribute("channels", channels);
		request.getRequestDispatcher("/backend/channel/channel_list.jsp")
				.forward(request, response);
	}

	// 单查
	public void get(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Channel c = channelDao.get(id);//调用ChannelDao的单查方法
		request.setAttribute("channel", c);
		request.getRequestDispatcher("/backend/channel/update_input.jsp")
				.forward(request, response);
	}

}
