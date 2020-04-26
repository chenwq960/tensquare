package org.tensquare_user.service;

import java.util.List;

import org.tensquare_user.form.SearchParam;
import org.tensquare_user.pojo.User;

public interface UserService {

	List<User> selectList(SearchParam searchParam);

	int save(User user);

	void sendMessage(String tel);

	User login(User user);

	void delte(String id);


}
