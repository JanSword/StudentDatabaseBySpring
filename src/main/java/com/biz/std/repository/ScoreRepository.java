package com.biz.std.repository;

import com.biz.std.domain.Score;
import com.biz.std.domain.Student;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by dell on 2017/5/11.
 */
//@RepositoryDefinition(domainClass = Score.class,idClass = Integer.class)
public interface ScoreRepository extends JpaRepository<Score,Integer> {

    Score findById(int id);

    List findByStudentid(int id);

    @Query("select o.subjectid from Score o where o.studentid=?1")
    List getSubjectidByStudentid(int studentid);

    @Query("select o.id from Score o where o.studentid=?1")
    List getIdByStudentid(int studentid);

    @Query("select o.studentid from Score o where o.subjectid=?1")
    List getStudentidBySubjectid(int subjectid);

    @Query("select o.id from Score o where o.subjectid=?1")
    List getIdBySubjectid(int subjectid);

    @Query("select count(o.subjectid) from Score o where o.studentid=?1")
    Object getSubjectNum(int studentid);

    @Query("select count(o.studentid) from Score o where o.subjectid=?1")
    Object getElectiveNum(int subjectid);

    @Query("select avg(o.score) from Score o where o.studentid=?1 and o.score is not null and o.score <>0")
    Object getAvg(int studentid);

    @Query("select avg(o.score) from Score o where o.subjectid=?1 and o.score is not null and o.score <>0")
    Object getSubjectAvg(int subjectid);

    @Query("select count(o.subjectid) from Score o where o.studentid=?1 and o.score is not null and o.score <>0")
    Object checkStudentHaveScore(int studentid);

    @Query("select count(o.studentid) from Score o where o.subjectid=?1 and o.score is not null and o.score <>0")
    Object checkSubjectHaveScore(int subjectid);

    @Query("select count(o.studentid) from Score o where o.subjectid=?1")
    Object checkSubjectHaveStudent(int subjectid);

    @Query("select count(o.subjectid) from Score o where o.studentid=?1")
    Object checkStudentHaveSubject(int studentid);

    @Query("select count(o.id) from Score o where o.studentid=?1 and o.subjectid=?2")
    Object checkHaveElectived(int studentid, int subjectid);
}
