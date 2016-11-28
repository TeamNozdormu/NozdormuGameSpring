package com.nozdormu.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "bullets")
public class Bullet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "loc_x", nullable = false)
    private Integer locationX;

    @Column(name = "loc_y", nullable = false)
    private Integer locationY;

    @Column(name = "speed", nullable = false)
    private Integer speed;

    public Bullet() {
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

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
}
