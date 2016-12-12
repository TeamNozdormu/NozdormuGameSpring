package com.nozdormu.repository;

import org.springframework.data.repository.CrudRepository;

import com.nozdormu.entities.Enemy;

public interface EnemyRepository extends CrudRepository<Enemy, Long> {
	Enemy findEnemyById(Long id);
}
