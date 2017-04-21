package com.medusa.bhsq.dao;

import java.util.List;

import com.medusa.bhsq.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> findall();

	List<User> findbyopenid(String openids);
	
	User findbyid(int id);
}