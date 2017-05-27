package com.biz.std.repository;

import com.biz.std.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dell on 2017/5/11.
 */
//@RepositoryDefinition(domainClass = Subject.class,idClass = Integer.class)
public interface SubjectRepository extends JpaRepository<Subject,Integer> {

    Subject findBySubjectid(int subjectid);

}
