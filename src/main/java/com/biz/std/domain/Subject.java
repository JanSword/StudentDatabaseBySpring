package com.biz.std.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by dell on 2017/5/10.
 */
@Entity
public class Subject {

    @GeneratedValue
    @Id
    private int subjectid;

    @Column(name="subjectname",length = 20,nullable = false)
    private String subjectname;

    @Column(name="electivenum",nullable = true)
    private int electivenum;

    @Column(name="subjectavg",nullable = true)
    private float subjectavg;


    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public int getElectivenum() {
        return electivenum;
    }

    public void setElectivenum(int electivenum) {
        this.electivenum = electivenum;
    }

    public float getSubjectavg() {
        return subjectavg;
    }

    public void setSubjectavg(float subjectavg) {
        this.subjectavg = subjectavg;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectid=" + subjectid +
                ", subjectname='" + subjectname + '\'' +
                ", electivenum=" + electivenum +
                ", subjectavg=" + subjectavg +
                '}';
    }
}
