package com.nozdormu.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nozdormu.dto.BulletDto;
import com.nozdormu.entities.Bullet;
import com.nozdormu.parser.interfaces.ModelParser;
import com.nozdormu.repository.BulletRepository;
import com.nozdormu.service.BulletService;

@Service
public class BulletServiceImpl implements BulletService{
	
	@Autowired
	private BulletRepository bulletRepository;
	
	@Autowired
	private ModelParser modelParser;
	
	@Override
	public void create(BulletDto bulletDto) {
		Bullet bullet = this.modelParser.convert(bulletDto, Bullet.class);
		this.getBulletRepository().save(bullet);
	}

	public BulletRepository getBulletRepository() {
		return this.bulletRepository;
	}

	public void setBulletRepository(BulletRepository bulletRepository) {
		this.bulletRepository = bulletRepository;
	}
}