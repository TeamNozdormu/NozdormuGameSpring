package com.nozdormu.entities.settings;

import javax.persistence.*;

@Entity
@Table(name = "player_setting")
public class PlayerSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "initial_number_of_lives", nullable = false)
    private Integer initialNumberOfLives;   //3

    @Column(name = "default_scores", nullable = false)
    private Integer defaultScores;  //0

    @Column(name = "default_speed", nullable = false)
    private Integer defaultSpeed;   //15

    @Column(name = "default_name", nullable = false)
    private String defaultName;    //"Nozdormu Warrior"

    @Column(name = "default_loc_x", nullable = false)
    private Integer defaultLocationX;   //GAME_WIDTH / 2 - 40;

    @Column(name = "default_loc_y", nullable = false)
    private Integer defaultLocationY;   //GAME_HEIGHT - 70

    public PlayerSetting() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInitialNumberOfLives() {
        return initialNumberOfLives;
    }

    public void setInitialNumberOfLives(Integer initialNumberOfLives) {
        this.initialNumberOfLives = initialNumberOfLives;
    }

    public Integer getDefaultScores() {
        return defaultScores;
    }

    public void setDefaultScores(Integer defaultScores) {
        this.defaultScores = defaultScores;
    }

    public Integer getDefaultSpeed() {
        return defaultSpeed;
    }

    public void setDefaultSpeed(Integer defaultSpeed) {
        this.defaultSpeed = defaultSpeed;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    public Integer getDefaultLocationX() {
        return defaultLocationX;
    }

    public void setDefaultLocationX(Integer defaultLocationX) {
        this.defaultLocationX = defaultLocationX;
    }

    public Integer getDefaultLocationY() {
        return defaultLocationY;
    }

    public void setDefaultLocationY(Integer defaultLocationY) {
        this.defaultLocationY = defaultLocationY;
    }
}
