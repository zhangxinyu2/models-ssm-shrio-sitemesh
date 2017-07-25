package com.modelssm.shiroadmin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.modelssm.adminuser.entity.AdminUser;
import com.modelssm.pageutil.PageUtil;
import com.modelssm.shiroadmin.dao.IAdminUserDao;
import com.modelssm.shiroadmin.service.IAdminUserService;
import com.modelssm.verifyparam.VerifyParams;

@Service
public class AdminUserServiceImpl implements IAdminUserService {

	@Autowired
	private IAdminUserDao iAdminUserDao;
	
	@Override
	public int addUser(AdminUser u) {
		return iAdminUserDao.addUser(u);
	}

	@Override
	public List<AdminUser> queryUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminUser queryAdminUser(Map<String, Object> params) {
		params=VerifyParams.verify(params);
		return iAdminUserDao.queryAdminUser(params);
	}

	@Override
	public Page<AdminUser> queryAdminUserList(Map<String, Object> params,
			int pageNumber, int pageSize) {
		long total=iAdminUserDao.queryAdminUserTotal(params);
		List<AdminUser> userList=new ArrayList<AdminUser>();
		if(total!=0){
			userList=iAdminUserDao.queryPageAdminUserList(params,pageNumber,pageSize);
		}
		PageRequest page= PageUtil.pageDealwith(pageNumber, pageSize, "auto");
		return new PageImpl<AdminUser>(userList, page, total);
	}

	@Override
	public void updateRealName(AdminUser au) {
		iAdminUserDao.updateRealName(au);
	}

	@Override
	public boolean deleteById(Integer id) {
		iAdminUserDao.deleteById(id);
		return true;
	}

}
