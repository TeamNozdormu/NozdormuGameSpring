package com.nozdormu.serviceImpl.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nozdormu.entities.setting.PlayerSetting;
import com.nozdormu.repository.setting.PlayerSettingRepository;
import com.nozdormu.service.setting.PlayerSettingService;

@Service
public class PlayerSettingServiceImpl implements PlayerSettingService{

	@Autowired
	private PlayerSettingRepository playerSettingRepository;
	
	@Override
	public void create(PlayerSetting playerSetting) {
		this.getPlayerSettingRepository().saveAndFlush(playerSetting);
	}

	public PlayerSettingRepository getPlayerSettingRepository() {
		return this.playerSettingRepository;
	}

	public void setPlayerSettingRepository(PlayerSettingRepository playerSettingRepository) {
		this.playerSettingRepository = playerSettingRepository;
	}

	
}
