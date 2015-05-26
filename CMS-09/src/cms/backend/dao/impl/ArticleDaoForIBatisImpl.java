package cms.backend.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cms.backend.dao.ArticleDao;
import cms.model.Article;
import cms.model.Channel;
import cms.model.PageModel;
import cms.utils.DateConverter;
import cms.utils.IDB;
import cms.utils.SystemContext;

public class ArticleDaoForIBatisImpl implements ArticleDao {

	// ���
	public void save(Article a) {
		SqlSession session = IDB.getSession();
		try {
			session.insert(Article.class.getName() + ".save", a);
			
			//��ӹؼ��ֵ���һ����ÿ���ؼ��ֶ�Ӧһ����¼
			Map params = new HashMap();
			if(a.getKeyword()!=null&& !a.getKeyword().trim().equals("")){
				String[] keywords = a.getKeyword().split(",| ");//���տո�򶺺Ÿ���
				for (String keyword : keywords) {
					params.put("articleId", a.getId());
					params.put("keyword", keyword);
					session.insert(Article.class.getName()+".add_keyword",params);
				}
			}
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// ǰ̨��̬SQL��ѯ
	public List<Article> query(String titleKey, String channelId,
			boolean isHeaderLine, boolean isRecommend, boolean isLatest) {
		Map params = new HashMap();
		List articles = new ArrayList();

		int rowCount = this.getRowCount(titleKey, channelId, isHeaderLine,
				isRecommend, isLatest);
		if (rowCount != 0) {
			SqlSession session = IDB.getSession();
			PageModel pm = SystemContext.getPM();
			pm.setRowCount(rowCount);
			params.put("title", "%" + titleKey + "%");
			params.put("channelId", channelId);
			params.put("headerLine", isHeaderLine);
			params.put("recommend", isRecommend);
			params.put("latest", isLatest);
			params.put("pm", pm);
			try {
				articles = session.selectList(Article.class.getName()
						+ ".queryForSite", params);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		return articles;
	}

	//��������id,��ѯ��ؼ���,������������б�
	public List<Article> related(int id) {
		SqlSession session = IDB.getSession();
		PageModel pm = SystemContext.getPM();
		List articleIds = new ArrayList();
		List<Article> articles = new ArrayList<Article>();
		Map params = new HashMap();
		try {
			//ȡ���������ID
			articleIds = session.selectList(Article.class.getName()+".getArticleIds", id);
			//��IDд��һ���ַ�����
			StringBuffer ids = new StringBuffer();
			for(int i=0;i<articleIds.size();i++){
				ids.append(articleIds.get(i));
				if(i<articleIds.size()-1){
					ids.append(",");
				}
			}
			params.put("articleIds", ids.toString());
			params.put("pm", pm);
			//��ѯ���������
			articles = session.selectList(Article.class.getName()+".getArticleByIds", params);
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return articles;
	}
	
	// ���
	public List<Article> query(String titleKey) {
		List articles = new ArrayList();
		int rowCount = this.getRowCount(titleKey);
		if (rowCount != 0) {
			SqlSession session = IDB.getSession();
			PageModel pm = SystemContext.getPM();
			pm.setRowCount(rowCount);
			Map params = new HashMap();
			params.put("title", "%" + titleKey + "%");
			params.put("pm", pm);

			try {
				articles = session.selectList(Article.class.getName()+ ".queryForBackend", params);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		return articles;
	}

	// ����
	public Article get(int id) {
		SqlSession session = IDB.getSession();
		Article a = null;
		List<String> keywords = new ArrayList<String>();
		try {
			a = (Article) session.selectOne(Article.class.getName() + ".get",id);
			//��������id��ѯ�ؼ���
			keywords = (List<String>)session.selectList(Article.class.getName()+".getKeywordByArticleId", id);
			StringBuffer sb = new StringBuffer();
			for (int i=0;i<keywords.size();i++) {
				sb.append(keywords.get(i));
				if(i<keywords.size()-1){
					//�ؼ����ö��Ÿ���
					sb.append(",");
				}
			}
			a.setKeyword(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return a;
	}

	// ɾ��
	public void delete(int id) {
		SqlSession session = IDB.getSession();
		try {
			session.delete(Article.class.getName() + ".delete", id);
			//ɾ������ͬʱɾ���������� 
			session.delete(Article.class.getName() + ".deleteMessage", id);
			//ɾ������ͬʱɾ�����¹ؼ���
			session.delete(Article.class.getName()+".deleteKeyword",id);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// ����
	public void update(Article a) {
		SqlSession session = IDB.getSession();
		try {
			session.update(Article.class.getName() + ".update", a);
			//���¹ؼ��֣���ɾ��ԭ�����ٲ����µ�
			session.delete(Article.class.getName()+".deleteKeyword",a.getId());
			//��ӹؼ��ֵ���һ����ÿ���ؼ��ֶ�Ӧһ����¼
			Map params = new HashMap();
			if(a.getKeyword()!=null&& !a.getKeyword().trim().equals("")){
				String[] keywords = a.getKeyword().split(",| ");//���տո�򶺺Ÿ���
				for (String keyword : keywords) {
					params.put("articleId", a.getId());
					params.put("keyword", keyword);
					session.insert(Article.class.getName()+".add_keyword",params);
				}
			}
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// ���µ����
	public void updateClickScore(int id) {
		SqlSession session = IDB.getSession();
		try {
			session.update(Article.class.getName() + ".updateClickScore", id);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// ����������
	public void updateMsgCount(int id) {
		SqlSession session = IDB.getSession();
		try {
			session.update(Article.class.getName() + ".updateMsgCount", id);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	// ����
	public void publish(int id) {
		SqlSession session = IDB.getSession();
		try {
			session.update(Article.class.getName() + ".publish", id);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// ���֧�ֶ�̬sql��ѯ�ܼ�¼��
	private int getRowCount(String titleKey, String channelId,
			boolean isHeaderLine, boolean isRecommend, boolean isLatest) {
		SqlSession session = IDB.getSession();
		Map params = new HashMap();
		params.put("title", "%" + titleKey + "%");

		params.put("channelId", channelId);
		params.put("headerLine", isHeaderLine);
		params.put("recommend", isRecommend);
		params.put("latest", isLatest);

		int rowCount = (Integer) session.selectOne(Article.class.getName()
				+ ".getRowCountForSite", params);
		return rowCount;
	}

	// ����ܼ�¼��
	private int getRowCount(String titleKey) {
		SqlSession session = IDB.getSession();
		int rowCount = 0;
		try {
			rowCount = (Integer) session.selectOne(Article.class.getName()
					+ ".getRowCountForBackend", "%" + titleKey + "%");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rowCount;
	}

}
