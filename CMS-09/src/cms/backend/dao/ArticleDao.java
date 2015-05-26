package cms.backend.dao;

import java.util.List;

import cms.model.Article;
import cms.model.PageModel;

public interface ArticleDao {
	void save(Article a);
	List<Article> query(String titleKey, String channelId,boolean isHeaderLine, boolean isRecommend, boolean isLatest);
	List<Article> query(String titleKey);
	Article get(int id);
	void delete(int id);
	void update(Article a);
	void updateClickScore(int id);
	void updateMsgCount(int id);
	void publish(int id);
	List<Article> related(int id);
}
