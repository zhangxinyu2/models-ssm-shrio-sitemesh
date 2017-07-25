package com.modelssm.shiroadmin.dao;

import java.util.List;
import java.util.Map;

import com.modelssm.user.entity.User;


public interface IUserDao {

	int addUser(User u);

	List<User> queryUserList();
	/**
	 * 根据条件查询用户列表数
	 * @param param
	 * @return
	 */
	long queryUserTotal(Map<String, Object> param);
	/**
	 * 条件查询用户列表
	 * @param param
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	List<User> queryPageUserList(Map<String, Object> param, int pageNumber,
			int pageSize);

}
