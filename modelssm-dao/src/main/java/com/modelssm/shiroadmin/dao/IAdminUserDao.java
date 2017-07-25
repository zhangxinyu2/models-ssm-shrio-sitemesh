package com.modelssm.shiroadmin.dao;

import java.util.List;
import java.util.Map;

import com.modelssm.adminuser.entity.AdminUser;


public interface IAdminUserDao {

	int addUser(AdminUser u);

	List<AdminUser> queryUserList();
	/**
	 * 根据条件查询用户列表数
	 * @param param
	 * @return
	 */
	long queryAdminUserTotal(Map<String, Object> param);
	/**
	 * 条件查询用户列表
	 * @param param
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	List<AdminUser> queryPageAdminUserList(Map<String, Object> param, int pageNumber,
			int pageSize);

	AdminUser queryAdminUser(Map<String, Object> params);


	void updateRealName(AdminUser au);

	void deleteById(Integer id);

}
