package com.biz.std.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by dell on 2017/5/10.
 */
@Entity
//@Table(name="scoretest")
public class Score {

    @GeneratedValue
    @Id
    private int id;

    @Column(name="subjectid",nullable = false)
    private int subjectid;

    @Column(name="studentid",nullable = false)
    private int studentid;

    @Column(name="score",nullable = true)
    private int score;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", subjectid=" + subjectid +
                ", studentid=" + studentid +
                ", score=" + score +
                '}';
    }
}
