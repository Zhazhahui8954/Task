package com.shanxijuzhi.juzhi.service.impl;

import com.shanxijuzhi.juzhi.mapper.UserMapper;
import com.shanxijuzhi.juzhi.model.User;
import com.shanxijuzhi.juzhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    public User login(String loginAct, String loginPwd1) {


        //根据账户和密码查询用户信息
        User user = userMapper.selectUserByLoginActPwd(loginAct,loginPwd1);

        if (null != user && user.getStatus() == 1){
            User updateUser = new User();
            updateUser.setId(user.getId());
            updateUser.setLastlogintime(new Date());

            //更新最近登陆的时间
            userMapper.updateByPrimaryKeySelective(updateUser);
        }
        return user;
    }
}
