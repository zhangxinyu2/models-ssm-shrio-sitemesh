package com.modelssm.shiroadmin.dao;

import java.util.List;
import java.util.Map;

import com.modelssm.adminrole.entity.AdminRole;

public interface IAdminRoleDao {

	List<AdminRole> queryRole(Map<String, Object> params);

	void saveRole(AdminRole ar);

	int deletById(Integer id);


}
