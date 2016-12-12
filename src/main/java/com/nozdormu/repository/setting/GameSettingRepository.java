package com.nozdormu.repository.setting;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nozdormu.entities.settings.GameSetting;

@Repository
public interface GameSettingRepository extends CrudRepository<GameSetting, Long>{
	GameSetting findGameSettingByGameWidth(Integer gameWidth);
}
