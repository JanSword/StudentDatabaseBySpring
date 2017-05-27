package com.biz.std.repository;

import com.biz.std.domain.Grade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * Created by dell on 2017/5/11.
 */
//@RepositoryDefinition(domainClass = Grade.class,idClass = Integer.class)
public interface GradeCrudRepository extends CrudRepository<Grade,Integer> {
}
