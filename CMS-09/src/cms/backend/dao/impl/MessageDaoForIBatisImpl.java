package cms.backend.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cms.backend.dao.MessageDao;
import cms.model.Message;
import cms.model.PageModel;
import cms.utils.IDB;
import cms.utils.SystemContext;

public class MessageDaoForIBatisImpl implements MessageDao {

	// 添加
	public void save(Message m) {
		SqlSession session = IDB.getSession();
		try {
			session.insert(Message.class.getName() + ".save", m);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	// 多查
	public List<Message> query(int articleId) {
		int rowCount = this.getRowCount(articleId);
		List messages = new ArrayList();
		if (rowCount != 0) {
			SqlSession session = IDB.getSession();
			PageModel pm = SystemContext.getPM();
			pm.setRowCount(rowCount);
			Map params = new HashMap();
			params.put("articleId", articleId);
			params.put("pm", pm);
			try {
				messages = session.selectList(Message.class.getName()
						+ ".query", params);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		return messages;
	}

	// 删除
	public void delete(int id) {
		SqlSession session = IDB.getSession();
		try {
			session.delete(Message.class.getName() + ".delete", id);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	// 取得总记录数
	public int getRowCount(int articleId) {
		SqlSession session = IDB.getSession();
		int rowCount = 0;
		try {
			rowCount = (Integer) session.selectOne(Message.class.getName()
					+ ".getRowCount", articleId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rowCount;
	}

}
