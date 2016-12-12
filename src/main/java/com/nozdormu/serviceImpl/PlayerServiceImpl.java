package com.nozdormu.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nozdormu.dto.PLayerDto;
import com.nozdormu.entities.Player;
import com.nozdormu.parser.interfaces.ModelParser;
import com.nozdormu.repository.PlayerRepository;
import com.nozdormu.service.PlayerService;

@Component
public class PlayerServiceImpl implements PlayerService{
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private ModelParser modelParser;


	public PlayerRepository getPlayerRepository() {
		return playerRepository;
	}


	public void setPlayerRepository(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}


	@Override
	public void create(PLayerDto playerDto) {
		Player player = this.modelParser.convert(playerDto, Player.class);
		this.playerRepository.save(player);
	}


	@Override
	public Player getPlayerByID(Long id) {
		return this.playerRepository.findPlayerById(id);
	}

}
