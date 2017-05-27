package com.biz.std.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by dell on 2017/5/10.
 */
@Entity
public class Student {

    @Id
    @Column(name="studentid",nullable = false)
    private int studentid;

    @Column(name="name",length = 12,nullable = false)
    private String name;

    @Column(name="sex",length = 4,nullable = false)
    private String sex;

    @Column(name="birthday",length = 20,nullable = false)
    private String birthday;

    @Column(name="grade",nullable = false)
    private int grade;

    @Column(name="subjectnum",nullable = true)
    private int subjectnum;

    @Column(name="avg",nullable = true)
    private float avg;

    @Column(name="img",nullable = true)
    private String img;


    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getSubjectnum() {
        return subjectnum;
    }

    public void setSubjectnum(int subjectnum) {
        this.subjectnum = subjectnum;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid=" + studentid +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", grade=" + grade +
                ", subjectnum=" + subjectnum +
                ", avg=" + avg +
                ", img='" + img + '\'' +
                '}';
    }
}
