package cms.backend.dao;

import cms.model.User;

public interface UserDao {
	boolean login(String username, String password, String checkcode,String sessioncodes);
	void add(User user);
}
