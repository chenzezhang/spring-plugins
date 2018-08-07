package com.plugins.monitoring.utils;

/**
 * @Auther: Rockzcz
 * @Date: 2018/8/7 09:05
 * @Description: 分页插件
 */
public class FindDate {
    public Integer page;
    public Integer pageSize;
    public int projectId;

    public FindDate(){};

    public FindDate(Integer page, Integer pageSize, int projectId) {
        this.page = page;
        this.pageSize = pageSize;
        this.projectId = projectId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
