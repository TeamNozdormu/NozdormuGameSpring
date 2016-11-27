package com.nozdormu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nozdormu.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Long>{
	Player findPlayerByName(String name);
	
	Player findPlayerById(Long id);
}
