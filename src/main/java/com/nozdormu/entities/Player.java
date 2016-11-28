package com.nozdormu.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    private String name;

    @Column(name = "number_of_lives")
    private Integer numberOfLives;

    @Column(name = "score")
    private Integer score;

    @Column(name = "current_bonus")
    private Integer currentBonus;

    @Column(name = "loc_x")
    private Integer locationX;

    @Column(name = "loc_y")
    private Integer locationY;

    @Column(name = "speed")
    private Integer speed;

    public Player() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfLives() {
        return numberOfLives;
    }

    public void setNumberOfLives(Integer numberOfLives) {
        this.numberOfLives = numberOfLives;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getCurrentBonus() {
        return currentBonus;
    }

    public void setCurrentBonus(Integer currentBonus) {
        this.currentBonus = currentBonus;
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

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
}
