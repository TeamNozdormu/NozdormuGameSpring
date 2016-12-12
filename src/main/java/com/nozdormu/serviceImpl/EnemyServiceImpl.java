package com.nozdormu.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nozdormu.entities.Enemy;
import com.nozdormu.repository.EnemyRepository;
import com.nozdormu.service.EnemyService;

@Component
public class EnemyServiceImpl implements EnemyService{
	
	@Autowired
	private EnemyRepository enemyRepository;

	@Override
	public void create(Enemy enemy) {
		this.getEnemyRepository().save(enemy);
	}

	public EnemyRepository getEnemyRepository() {
		return this.enemyRepository;
	}

	public void setEnemyRepository(EnemyRepository enemyRepository) {
		this.enemyRepository = enemyRepository;
	}

}
