package com.medusa.bhsq.entity;

import java.io.Serializable;

public class User implements Serializable{
    private Integer id;

    private String name;

    private String head;

    private Integer ex;

    private String introduction;

    private String sex;

    private String birth;

    private String wxnumber;

    private String openid;

    private Integer levelid;

    private String lasttime;
    
    private Level level;
    
    private boolean qd=false;

    public Level getLevel() {
		return level;
	}

	public boolean isQd() {
		return qd;
	}

	public void setQd(boolean qd) {
		this.qd = qd;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
    }

    public Integer getEx() {
        return ex;
    }

    public void setEx(Integer ex) {
        this.ex = ex;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }


    public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth == null ? null : birth.trim();
    }

    public String getWxnumber() {
        return wxnumber;
    }

    public void setWxnumber(String wxnumber) {
        this.wxnumber = wxnumber == null ? null : wxnumber.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getLevelid() {
        return levelid;
    }

    public void setLevelid(Integer levelid) {
        this.levelid = levelid;
    }

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime == null ? null : lasttime.trim();
    }
}