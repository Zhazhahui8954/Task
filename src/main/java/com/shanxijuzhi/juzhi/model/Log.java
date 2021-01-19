package com.shanxijuzhi.juzhi.model;

import java.util.Date;

public class Log {
    private Integer id;

    private Date logtime;

    private Integer userid;

    private String loginact;

    private String describe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLogtime() {
        return logtime;
    }

    public void setLogtime(Date logtime) {
        this.logtime = logtime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLoginact() {
        return loginact;
    }

    public void setLoginact(String loginact) {
        this.loginact = loginact;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}