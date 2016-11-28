package com.nozdormu.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nozdormu.enumerations.EnemyType;

@Entity
@Table(name = "enemies")
public class Enemy implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "loc_x")
    private Integer locationX;

    @Column(name = "loc_y")
    private Integer locationY;

    @Column(name = "health_points")
    private Integer healthPoints;

    @Column(name = "speed_multiplier")
    private Integer speedMultiplier;

    @Enumerated(EnumType.STRING)
    @Column(name = "enemy_type")
    private EnemyType enemyType;

    public Enemy() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLocationX() {
        return locationX;
    }

    public void setLocationX(Integer locationX) {
        this.locationX = locationX;
    }

    public Integer getLocationY() {
        return locationY;
    }

    public void setLocationY(Integer locationY) {
        this.locationY = locationY;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Integer getSpeedMultiplier() {
        return speedMultiplier;
    }

    public void setSpeedMultiplier(Integer speedMultiplier) {
        this.speedMultiplier = speedMultiplier;
    }

    public EnemyType getEnemyType() {
        return enemyType;
    }

    public void setEnemyType(EnemyType enemyType) {
        this.enemyType = enemyType;
    }
}
