package com.modelssm.shiroadmin.service;

import java.util.List;
import java.util.Map;

import com.modelssm.adminrole.entity.AdminRole;

public interface IAdminRoleService {

	List<AdminRole> queryRole(Map<String, Object> params);

	boolean queryExist(Map<String, Object> params);

	void saveRole(AdminRole ar);

	boolean deleteById(Integer id);

}
