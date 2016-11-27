package com.nozdormu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nozdormu.entities.Enemy;

public interface EnemyRepository extends JpaRepository<Enemy, Long> {
	Enemy findEnemyById(Long id);
}
