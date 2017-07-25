package com.modelssm.shiroadmin.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.modelssm.adminuser.entity.AdminUser;


public interface IAdminUserService {
	
	int addUser(AdminUser u);
	
	List<AdminUser> queryUserList();
	
	AdminUser queryAdminUser(Map<String, Object> params);

	Page<AdminUser> queryAdminUserList(Map<String, Object> params, int pageNumber,
			int pageSize);

	void updateRealName(AdminUser au);

	boolean deleteById(Integer id);
}
