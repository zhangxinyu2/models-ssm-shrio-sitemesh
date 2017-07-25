package com.modelssm.shiroadmin.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.modelssm.shiroadmin.dao.IUserDao;
import com.modelssm.user.entity.User;
import com.modelssm.user.mapper.UserMapper;


@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private UserMapper userMapper;
	@Override
	public int addUser(User u) {
		System.out.println(u.getName());
		return userMapper.insertSelective(u);
	}
	@Override
	public List<User> queryUserList() {
		return userMapper.queryUserList();
	}
	@Override
	public long queryUserTotal(Map<String, Object> param) {
		return userMapper.queryUserTotal(param);
	}
	@Override
	public List<User> queryPageUserList(Map<String, Object> param, int pageNumber,
			int pageSize) {
		return userMapper.queryPageUserList(param,new RowBounds(pageNumber, pageSize));
	}

}
