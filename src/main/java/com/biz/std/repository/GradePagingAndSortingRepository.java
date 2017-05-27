package com.biz.std.repository;

import com.biz.std.domain.Grade;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by dell on 2017/5/17.
 */
public interface GradePagingAndSortingRepository extends PagingAndSortingRepository<Grade,Integer> {
}
