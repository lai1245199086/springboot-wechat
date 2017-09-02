package com.cll.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.cll.entity.User;

public interface UserDao extends BaseDao<User>{

    @Select("select * from user where state = #{state}")
    public List<User> selectByState(Integer state);
}
