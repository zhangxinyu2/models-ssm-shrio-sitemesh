package com.modelssm.shiroadmin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.modelssm.pageutil.PageUtil;
import com.modelssm.shiroadmin.dao.IUserDao;
import com.modelssm.shiroadmin.service.IUserService;
import com.modelssm.user.entity.User;
import com.modelssm.verifyparam.VerifyParams;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao iUserDao;
	@Override
	public int addUser(User u) {
		return iUserDao.addUser(u);
	}
	@Override
	public List<User> queryUserList() {
		return iUserDao.queryUserList();
	}
	@Override
	public Page<User> queryUserList(Map<String, Object> param,
			int pageNumber, int pageSize) {
		param=VerifyParams.verify(param,VerifyParams.USER);
		long total=iUserDao.queryUserTotal(param);
		List<User> userList=new ArrayList<User>();
		if(total!=0){
			userList=iUserDao.queryPageUserList(param,pageNumber,pageSize);
		}
		PageRequest page= PageUtil.pageDealwith(pageNumber, pageSize, "auto");
		return new PageImpl<User>(userList, page, total);
	}

}
