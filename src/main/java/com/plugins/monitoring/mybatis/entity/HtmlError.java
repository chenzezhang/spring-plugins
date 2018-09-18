package com.plugins.monitoring.mybatis.entity;

import java.sql.Date;


/**
 * @Auther: Rockzcz
 * @Date: 2018/9/17 17:19
 * @Description: htmlError
 */
public class HtmlError {
    public String type;
    public String sMsg;
    public String sUrl;
    public String sLine;
    public String sCol;
    public String eObj;
    public Date sTime;
    public String bType;
    public int projectId;

    public HtmlError(){};

    public HtmlError(String type, String sMsg, String sUrl, String sLine, String sCol, String eObj, Date sTime, String bType, int projectId){
        this.type = type;
        this.sMsg = sMsg;
        this.sUrl = sUrl;
        this.sLine = sLine;
        this.sCol = sCol;
        this.eObj = eObj;
        this.sTime = sTime;
        this.bType = bType;
        this.projectId = projectId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getsMsg() {
        return sMsg;
    }

    public void setsMsg(String sMsg) {
        this.sMsg = sMsg;
    }

    public String getsUrl() {
        return sUrl;
    }

    public void setsUrl(String sUrl) {
        this.sUrl = sUrl;
    }

    public String getsLine() {
        return sLine;
    }

    public void setsLine(String sLine) {
        this.sLine = sLine;
    }

    public String getsCol() {
        return sCol;
    }

    public void setsCol(String sCol) {
        this.sCol = sCol;
    }

    public String geteObj() {
        return eObj;
    }

    public void seteObj(String eObj) {
        this.eObj = eObj;
    }

    public Date getsTime() {
        return sTime;
    }

    public void setsTime(Date sTime) {
        this.sTime = sTime;
    }

    public String getbType() {
        return bType;
    }

    public void setbType(String bType) {
        this.bType = bType;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getProjectId() {
        return projectId;
    }
}
