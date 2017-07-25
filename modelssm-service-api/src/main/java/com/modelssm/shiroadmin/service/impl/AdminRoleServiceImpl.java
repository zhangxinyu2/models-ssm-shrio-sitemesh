package com.modelssm.shiroadmin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modelssm.adminrole.entity.AdminRole;
import com.modelssm.shiroadmin.dao.IAdminRoleDao;
import com.modelssm.shiroadmin.service.IAdminRoleService;

@Service
public class AdminRoleServiceImpl implements IAdminRoleService {
	
	@Autowired
	private IAdminRoleDao iAdminRoleDao;
	
	@Override
	public List<AdminRole> queryRole(Map<String, Object> params) {
		return iAdminRoleDao.queryRole(params);
	}

	@Override
	public boolean queryExist(Map<String, Object> params) {
		List<AdminRole> arList= iAdminRoleDao.queryRole(params);
		if(arList.size()==0){
			return false;
		}
		return true;
	}

	@Override
	public void saveRole(AdminRole ar) {
		iAdminRoleDao.saveRole(ar);
	}

	@Override
	public boolean deleteById(Integer id) {
		if(iAdminRoleDao.deletById(id)!=0){
			return true;
		}
		return false;
	}

}
