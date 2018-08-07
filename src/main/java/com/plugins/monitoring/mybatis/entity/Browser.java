package com.plugins.monitoring.mybatis.entity;

/**
 * @Auther: Rockzcz
 * @Date: 2018/7/17 10:32
 * @Description: 浏览器信息实体
 */
public class Browser {
    private String account;
    private String source;
    private String userAgent;
    private String appVersion;
    private String localUrl;
    private String sh;
    private String sw;
    private String cd;
    private int total;
    private int projectId;

    public Browser(){};

    public Browser(String account, String source, String userAgent, String appVersion, String localUrl, String sh, String sw, String cd, int projectId, int total){
        this.account = account;
        this.source = source;
        this.userAgent = userAgent;
        this.appVersion = appVersion;
        this.localUrl = localUrl;
        this.sh = sh;
        this.sw = sw;
        this.cd = cd;
        this.projectId = projectId;
        this.total = total;
    }

    public int getTotal() {
        return total;
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
        this.userAgent = userAgent;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setLocalUrl(String localUrl) {
        this.localUrl = localUrl;
    }

    public String getLocalUrl() {
        return localUrl;
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
