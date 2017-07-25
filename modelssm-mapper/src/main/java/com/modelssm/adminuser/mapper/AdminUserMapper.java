package com.modelssm.adminuser.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.modelssm.adminuser.entity.AdminUser;

public interface AdminUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);

    //条件查询
	AdminUser queryAdminUser(Map<String, Object> params);
	//分页个数
	long queryAdminUserTotal(Map<String, Object> param);
	//分页内容
	List<AdminUser> queryPageAdminUserList(Map<String, Object> param,
			RowBounds rowBounds);
}