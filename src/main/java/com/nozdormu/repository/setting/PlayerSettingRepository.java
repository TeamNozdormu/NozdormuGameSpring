package com.nozdormu.repository.setting;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nozdormu.entities.settings.PlayerSetting;

@Repository
public interface PlayerSettingRepository extends CrudRepository<PlayerSetting, Long>{
	PlayerSetting findPlayerSettingByDefaultName(String name);
}
