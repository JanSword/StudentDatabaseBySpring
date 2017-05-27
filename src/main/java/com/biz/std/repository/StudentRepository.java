package com.biz.std.repository;

import com.biz.std.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by dell on 2017/5/11.
 */

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findByStudentid(int studentid);

    @Query("select o from Student o where o.name=?1")
    List<Student> findByName(String name);

    @Query("select count(o.studentid) from Student o where o.grade=?1")
    Object getStudentNum(int grade);

    @Query("select avg(o.avg) from Student o where o.grade=?1 and o.avg is not null and o.avg <>0" )
    Object getStudentAvg(int grade);

    @Query("select o.grade from Student o where o.studentid=?1")
    Object getGradeByStudentid(int studentid);

    @Query("select count(o.studentid) from Student o where o.grade=?1 and o.avg is not null and o.avg <>0")
    Object checkStudentsHaveScore(int grade);

    @Query("select count(o.studentid) from Student o where o.grade=?1 and o.avg is not null and o.avg <>0 ")
    Object checkGradeHaveNoZeroScore(int grade);

    @Query("select count(o.studentid) from Student o where o.grade=?1")
    Object checkGradeHaveStudents(int grade);

}
