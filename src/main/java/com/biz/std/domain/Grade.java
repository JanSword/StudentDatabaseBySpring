package com.biz.std.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by dell on 2017/5/10.
 */
@Entity
public class Grade {

    @GeneratedValue
    @Id
    private int gradeid;

    @Column(name="gradename",length = 10,nullable = false)
    private String gradename;

    @Column(name="studentnum",nullable = true)
    private int studentnum;

    @Column(name="gradeavg",nullable = true)
    private float gradeavg;

    public int getGradeid() {
        return gradeid;
    }

    public void setGradeid(int gradeid) {
        this.gradeid = gradeid;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename;
    }

    public int getStudentnum() {
        return studentnum;
    }

    public void setStudentnum(int studentnum) {
        this.studentnum = studentnum;
    }

    public float getGradeavg() {
        return gradeavg;
    }

    public void setGradeavg(float gradeavg) {
        this.gradeavg = gradeavg;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeid=" + gradeid +
                ", gradename='" + gradename + '\'' +
                ", studentnum=" + studentnum +
                ", gradeavg=" + gradeavg +
                '}';
    }
}
