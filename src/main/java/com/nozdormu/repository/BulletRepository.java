package com.nozdormu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nozdormu.entities.Bullet;

public interface BulletRepository extends JpaRepository<Bullet, Long>{
	Bullet findBulletById(Long id);
}
