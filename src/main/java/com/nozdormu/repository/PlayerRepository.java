package com.nozdormu.repository;

import org.springframework.data.repository.CrudRepository;

import com.nozdormu.entities.Player;

public interface PlayerRepository extends CrudRepository<Player, Long>{
	Player findPlayerByName(String name);
	
	Player findPlayerById(Long id);
}
