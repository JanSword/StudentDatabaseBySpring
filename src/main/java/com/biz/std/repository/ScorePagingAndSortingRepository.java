package com.biz.std.repository;

import com.biz.std.domain.Score;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by dell on 2017/5/17.
 */
public interface ScorePagingAndSortingRepository extends PagingAndSortingRepository<Score,Integer> {
}
