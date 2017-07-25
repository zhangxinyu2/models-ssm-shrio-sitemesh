package com.modelssm.shiroadmin.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.modelssm.user.entity.User;


public interface IUserService {
	
	/**
	 * 添加用户
	 * @param u
	 * @return
	 */
	int addUser(User u);
	/**
	 * 查询用户
	 * @return
	 */
	List<User> queryUserList();
	/**
	 * 查询分页用户列表
	 * @param param
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	Page<User> queryUserList(Map<String, Object> param, int pageNumber,
			int pageSize);

}
