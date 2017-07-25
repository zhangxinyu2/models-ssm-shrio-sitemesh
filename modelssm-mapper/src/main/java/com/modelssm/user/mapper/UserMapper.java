package com.modelssm.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.modelssm.user.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    /**
     * 查询用户列表
     * @return
     */
	List<User> queryUserList();
	/**
	 * 根据参数查询用户列表数
	 * @param param
	 * @return
	 */
	long queryUserTotal(Map<String, Object> param);
	/**
	 * 根据条件查询用户列表
	 * @param param
	 * @param rowBounds
	 * @return
	 */
	List<User> queryPageUserList(Map<String, Object> param, RowBounds rowBounds);
}