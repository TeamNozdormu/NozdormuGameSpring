package com.nozdormu.serviceImpl.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nozdormu.dto.settings.GameSettingDto;
import com.nozdormu.entities.settings.GameSetting;
import com.nozdormu.parser.interfaces.ModelParser;
import com.nozdormu.repository.setting.GameSettingRepository;
import com.nozdormu.service.setting.GameSettingService;

@Service
public class GameSettingServiceImpl implements GameSettingService{
	
	@Autowired
	private GameSettingRepository gameSettingRepository;
	
	@Autowired
	private ModelParser modelParser;

	@Override
	public void create(GameSettingDto gameSettingDto) {
		GameSetting gameSetting = this.getModelParser().convert(gameSettingDto, GameSetting.class);
		this.getGameSettingRepository().save(gameSetting);
	}

	public GameSettingRepository getGameSettingRepository() {
		return this.gameSettingRepository;
	}

	public void setGameSettingRepository(GameSettingRepository gameSettingRepository) {
		this.gameSettingRepository = gameSettingRepository;
	}

	public ModelParser getModelParser() {
		return modelParser;
	}

	public void setModelParser(ModelParser modelParser) {
		this.modelParser = modelParser;
	}
	
	
}
