package com.modelssm.shiroadmin.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.modelssm.adminuser.entity.AdminUser;
import com.modelssm.adminuser.mapper.AdminUserMapper;
import com.modelssm.shiroadmin.dao.IAdminUserDao;


@Repository
public class AdminUserDaoImpl implements IAdminUserDao {

	@Autowired
	private AdminUserMapper adminUserMapper;

	@Override
	public int addUser(AdminUser u) {
		return adminUserMapper.insertSelective(u);
	}

	@Override
	public List<AdminUser> queryUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long queryAdminUserTotal(Map<String, Object> param) {
		return adminUserMapper.queryAdminUserTotal(param);
	}

	@Override
	public List<AdminUser> queryPageAdminUserList(Map<String, Object> param,
			int pageNumber, int pageSize) {
		return adminUserMapper.queryPageAdminUserList(param,new RowBounds(pageNumber, pageSize));
	}

	@Override
	public AdminUser queryAdminUser(Map<String, Object> params) {
		return adminUserMapper.queryAdminUser(params);
	}

	@Override
	public void updateRealName(AdminUser au) {
		adminUserMapper.updateByPrimaryKeySelective(au);
	}

	@Override
	public void deleteById(Integer id) {
		adminUserMapper.deleteByPrimaryKey(id);
	}

}
