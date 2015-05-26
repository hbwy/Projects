package cms.backend.dao;

import java.util.List;

import cms.model.Message;
import cms.model.PageModel;

public interface MessageDao {
	void save(Message m);
	List<Message> query(int articleId);
	void delete(int id);
}
