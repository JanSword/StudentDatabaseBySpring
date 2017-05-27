package com.biz.std.repository;

import com.biz.std.domain.Grade;
import com.biz.std.domain.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by dell on 2017/5/11.
 */
//@RepositoryDefinition(domainClass = Grade.class,idClass = Integer.class)
public interface GradeRepository extends JpaRepository<Grade, Integer> {

    Grade findByGradeid(int gradeid);

    @Query("select count(o.gradename) from Grade o where o.gradeid=?1")
    Object checkGradeExist(int gradeid);

    @Query("select o.gradeid from Grade o")
    List findAllGradeid();
}
