package com.nozdormu.service;

import com.nozdormu.dto.PLayerDto;
import com.nozdormu.entities.Player;

public interface PlayerService {
	void create(PLayerDto player);
	Player getPlayerByID(Long id);
}
