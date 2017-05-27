package com.biz.std.repository;

import com.biz.std.domain.Score;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dell on 2017/5/11.
 */
public interface ScoreCrudRepository extends CrudRepository<Score,Integer> {
}
