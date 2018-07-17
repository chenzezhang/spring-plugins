package com.plugins.monitoring.mybatis.entity;

/**
 * @Auther: Rockzcz
 * @Date: 2018/7/17 10:32
 * @Description: 浏览器信息实体
 */
public class Browser {
    private String account;
    private String source;
    private String user_agent;
    private String app_version;
    private String local_url;
    private String sh;
    private String sw;
    private String cd;
    private int projectId;

    public Browser(){};

    public Browser(String account, String source, String user_agent, String app_version, String local_url, String sh, String sw, String cd, int projectId){
        this.account = account;
        this.source = source;
        this.user_agent = user_agent;
        this.app_version = app_version;
        this.local_url = local_url;
        this.sh = sh;
        this.sw = sw;
        this.cd = cd;
        this.projectId = projectId;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setUserAgent(String userAgent) {
        this.user_agent = userAgent;
    }

    public String getUserAgent() {
        return user_agent;
    }

    public void setAppVersion(String appVersion) {
        this.app_version = appVersion;
    }

    public String getAppVersion() {
        return app_version;
    }

    public void setLocalUrl(String localUrl) {
        this.local_url = localUrl;
    }

    public String getLocalUrl() {
        return local_url;
    }

    public void setSh(String sh) {
        this.sh = sh;
    }

    public String getSh() {
        return sh;
    }

    public void setSw(String sw) {
        this.sw = sw;
    }

    public String getSw() {
        return sw;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getCd() {
        return cd;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getProjectId() {
        return projectId;
    }
}
