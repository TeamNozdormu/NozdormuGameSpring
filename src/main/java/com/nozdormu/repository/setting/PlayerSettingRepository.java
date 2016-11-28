package com.nozdormu.repository.setting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nozdormu.entities.setting.PlayerSetting;

@Repository
public interface PlayerSettingRepository extends JpaRepository<PlayerSetting, Long>{
	PlayerSetting findPlayerSettingByDefaultName(String name);
}
