package com.nozdormu.serviceImpl.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nozdormu.dto.settings.PlayerSettingDto;
import com.nozdormu.entities.settings.PlayerSetting;
import com.nozdormu.parser.interfaces.ModelParser;
import com.nozdormu.repository.setting.PlayerSettingRepository;
import com.nozdormu.service.setting.PlayerSettingService;

@Service
public class PlayerSettingServiceImpl implements PlayerSettingService{

	@Autowired
	private PlayerSettingRepository playerSettingRepository;
	
	@Autowired
	private ModelParser modelParser;
	
	@Override
	public void create(PlayerSettingDto playerSettingDto) {
		PlayerSetting playerSetting = this.getModelParser().convert(playerSettingDto, PlayerSetting.class);
		this.getPlayerSettingRepository().save(playerSetting);
	}

	public PlayerSettingRepository getPlayerSettingRepository() {
		return this.playerSettingRepository;
	}

	public void setPlayerSettingRepository(PlayerSettingRepository playerSettingRepository) {
		this.playerSettingRepository = playerSettingRepository;
	}

	public ModelParser getModelParser() {
		return modelParser;
	}

	public void setModelParser(ModelParser modelParser) {
		this.modelParser = modelParser;
	}

	
}
