package com.powernode.mybatis.pojo;

import java.util.List;

/**
 * 班级信息
 */
public class Clazz {
    private Integer cid;
    private String cname;
    private List<Student> stus;

    public List<Student> getStus() {
        return stus;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", stus=" + stus +
                '}';
    }

    public void setStus(List<Student> stus) {
        this.stus = stus;
    }


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
