package com.nozdormu.repository.setting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nozdormu.entities.setting.GameSetting;

@Repository
public interface GameSettingRepository extends JpaRepository<GameSetting, Long>{
	GameSetting findGameSettingByGameWidth(Integer gameWidth);
}
