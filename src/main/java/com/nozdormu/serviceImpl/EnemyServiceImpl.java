package com.nozdormu.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nozdormu.dto.EnemyDto;
import com.nozdormu.entities.Enemy;
import com.nozdormu.parser.interfaces.ModelParser;
import com.nozdormu.repository.EnemyRepository;
import com.nozdormu.service.EnemyService;

@Component
public class EnemyServiceImpl implements EnemyService{
	
	@Autowired
	private EnemyRepository enemyRepository;
	
	@Autowired
	private ModelParser modelParser;

	@Override
	public void create(EnemyDto enemyDto) {
		Enemy enemy = this.getModelParser().convert(enemyDto, Enemy.class);
		this.getEnemyRepository().save(enemy);
	}

	public EnemyRepository getEnemyRepository() {
		return this.enemyRepository;
	}

	public void setEnemyRepository(EnemyRepository enemyRepository) {
		this.enemyRepository = enemyRepository;
	}

	public ModelParser getModelParser() {
		return this.modelParser;
	}

	public void setModelParser(ModelParser modelParser) {
		this.modelParser = modelParser;
	}
	
	

}
