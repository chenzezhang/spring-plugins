package com.plugins.monitoring.mybatis.service;

import com.plugins.monitoring.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.plugins.monitoring.mybatis.entity.User;


/**
 * @Auther: Rockzcz
 * @Date: 2018/7/3 08:42
 * @Description: service 用户信息
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int addUser(User user) {
        return userMapper.insert( user );
    }

    public User getUserName(String username) {
        return userMapper.getUserName( username );
    }

    public User getUserId(int user_id) {
        return userMapper.getUserInfo( user_id );
    }

    /**
     * 数据库更新
     * @param user_name
     * @return
     */
    public void updateValue(User user_name) {
        userMapper.update( user_name );
    }

}
