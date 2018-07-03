package com.plugins.monitoring.mybatis.service;

import com.plugins.monitoring.mybatis.entity.Role;
import com.plugins.monitoring.mybatis.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Auther: Rockzcz
 * @Date: 2018/7/3 08:56
 * @Description: role service
 */

@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;


    public Role getRoleName(String roleName){
        return roleMapper.getRoleName( roleName );
    }

    public int insert(Role role) {
        return roleMapper.insert( role );
    }
}
