package cms.backend.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cms.backend.dao.ChannelDao;
import cms.model.Channel;
import cms.utils.IDB;

public class ChannelDaoForIBatisImpl implements ChannelDao {
	//添加
	public void save(Channel c) {
		SqlSession session = IDB.getSession();
		try {
			session.insert(Channel.class.getName()+".save", c);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	//更新
	public void update(Channel c) {
		SqlSession session = IDB.getSession();
		try {
			session.update(Channel.class.getName()+".update", c);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	//删除
	public void delete(String id) {
		SqlSession session = IDB.getSession();
		try {
			session.delete(Channel.class.getName()+".delete",id);
			session.delete(Channel.class.getName()+".deleteArticle",id);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}

	}

	//多查
	public List<Channel> query() {
		SqlSession session = IDB.getSession();
		List channels = new ArrayList();
		try {
			channels = session.selectList(Channel.class.getName()+".query");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return channels;
	}
	
	//单查
	public Channel get(String id) {
		SqlSession session = IDB.getSession();
		Channel channel = null;
		try {
			channel = (Channel)session.selectOne(Channel.class.getName()+".get",id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return channel;
	}

}
