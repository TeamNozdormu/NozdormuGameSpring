package com.nozdormu.repository;

import org.springframework.data.repository.CrudRepository;

import com.nozdormu.entities.Bullet;

public interface BulletRepository extends CrudRepository<Bullet, Long>{
	Bullet findBulletById(Long id);
}
