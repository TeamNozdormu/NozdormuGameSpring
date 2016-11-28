package com.nozdormu.serviceImpl.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nozdormu.entities.setting.GameSetting;
import com.nozdormu.repository.setting.GameSettingRepository;
import com.nozdormu.service.setting.GameSettingService;

@Service
public class GameSettingServiceImpl implements GameSettingService{
	
	@Autowired
	private GameSettingRepository gameSettingRepository;

	@Override
	public void create(GameSetting gameSetting) {
		this.getGameSettingRepository().saveAndFlush(gameSetting);
	}

	public GameSettingRepository getGameSettingRepository() {
		return this.gameSettingRepository;
	}

	public void setGameSettingRepository(GameSettingRepository gameSettingRepository) {
		this.gameSettingRepository = gameSettingRepository;
	}
	
}
