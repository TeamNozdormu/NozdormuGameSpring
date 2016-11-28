package com.nozdormu.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nozdormu.entities.Player;
import com.nozdormu.repository.PlayerRepository;
import com.nozdormu.service.PlayerService;

@Component
public class PlayerServiceImpl implements PlayerService{
	
	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public void create(Player player) {
		this.getPlayerRepository().saveAndFlush(player);
	}

	public PlayerRepository getPlayerRepository() {
		return this.playerRepository;
	}

	public void setPlayerRepository(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}
}
