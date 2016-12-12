package com.nozdormu.entities.settings;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "game_setting")
public class GameSetting implements Serializable{

	private static final long serialVersionUID = 2236973499184667373L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "game_width", nullable = false)
    private Integer gameWidth;  //800

    @Column(name = "game_height", nullable = false)
    private Integer gameHeight; //600

    @Column(name = "game_name")
    private String gameName;    //"Nozdormu Battle Invasion";

    public GameSetting() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGameWidth() {
        return gameWidth;
    }

    public void setGameWidth(Integer gameWidth) {
        this.gameWidth = gameWidth;
    }

    public Integer getGameHeight() {
        return gameHeight;
    }

    public void setGameHeight(Integer gameHeight) {
        this.gameHeight = gameHeight;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
