package com.udacity.bootstrap.repository;

import com.udacity.bootstrap.entity.Cat;
import org.springframework.data.repository.CrudRepository;

public interface CatRepository extends CrudRepository<Cat, Long> {
}
