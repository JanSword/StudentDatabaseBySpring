package com.biz.std.repository;

import com.biz.std.domain.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dell on 2017/5/11.
 */
public interface StudentCrudRepository extends CrudRepository<Student,Integer> {
}
