package com.plugins.monitoring.mybatis.service;

import com.plugins.monitoring.mybatis.entity.Project;
import com.plugins.monitoring.mybatis.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Auther: Rockzcz
 * @Date: 2018/7/3 08:59
 * @Description: project
 */

@Service
public class ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    public int insert(Project project) {
        return projectMapper.insert( project );
    }

    public Project getPermissions(String role_id) {
        return projectMapper.getPermissions( role_id );
    }
}
