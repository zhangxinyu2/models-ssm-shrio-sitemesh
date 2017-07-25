package com.modelssm.shiroadmin.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.modelssm.adminrole.entity.AdminRole;
import com.modelssm.adminrole.mapper.AdminRoleMapper;
import com.modelssm.shiroadmin.dao.IAdminRoleDao;
@Repository
public class AdminRoleDaoImpl implements IAdminRoleDao {

	@Autowired
	private AdminRoleMapper adminRoleMapper;
	
	@Override
	public List<AdminRole> queryRole(Map<String, Object> params) {
		return adminRoleMapper.queryRole(params);
	}

	@Override
	public void saveRole(AdminRole ar) {
		adminRoleMapper.insertSelective(ar);
	}

	@Override
	public int deletById(Integer id) {
		return adminRoleMapper.deleteByPrimaryKey(id);
	}

}
