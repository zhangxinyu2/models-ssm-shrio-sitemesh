package com.modelssm.adminrole.mapper;

import java.util.List;
import java.util.Map;

import com.modelssm.adminrole.entity.AdminRole;

public interface AdminRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminRole record);

    int insertSelective(AdminRole record);

    AdminRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminRole record);

    int updateByPrimaryKey(AdminRole record);

	List<AdminRole> queryRole(Map<String, Object> params);
}