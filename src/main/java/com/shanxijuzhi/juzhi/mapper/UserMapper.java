package com.shanxijuzhi.juzhi.mapper;

import com.shanxijuzhi.juzhi.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserByLoginActPwd(String loginAct, String loginPwd1);
}