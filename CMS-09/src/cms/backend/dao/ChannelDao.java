package cms.backend.dao;

import java.util.List;

import cms.model.Channel;

public interface ChannelDao {
	void save(Channel c);
	void update(Channel c);
	void delete(String id);
	List<Channel> query();
	Channel get(String id);
}
