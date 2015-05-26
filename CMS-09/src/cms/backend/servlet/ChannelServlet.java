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

	// ����
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Channel c = (Channel)RequestUtil.copyParam(Channel.class, request);
		channelDao.save(c);  //����ChannelDao����ӷ���
		response.sendRedirect(request.getContextPath()
				+ "/backend/channel/add_channel_success.jsp");
	}

	// �޸�
	public void modify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Channel c = (Channel)RequestUtil.copyParam(Channel.class, request);
		channelDao.update(c);//����ChannelDao�ĸ��·���
		//list(request, response); // ���ö�飬��ʾ�޸ĺ�Ľ��
		request.getRequestDispatcher("/backend/ChannelServlet?m=list").forward(request, response);
	}

	// ɾ��
	public void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		channelDao.delete(id);
		request.getRequestDispatcher("/backend/ChannelServlet?m=list").forward(request, response);

	}

	// ���
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Channel> channels = channelDao.query();
		request.setAttribute("channels", channels);
		request.getRequestDispatcher("/backend/channel/channel_list.jsp")
				.forward(request, response);
	}

	// ����
	public void get(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Channel c = channelDao.get(id);//����ChannelDao�ĵ��鷽��
		request.setAttribute("channel", c);
		request.getRequestDispatcher("/backend/channel/update_input.jsp")
				.forward(request, response);
	}

}
