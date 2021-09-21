/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gojek.battleship.model;

/**
 *
 * @author prabandi
 */
public class BoardCell {
    private int x;
    private int y;
    private Ship ship;
    private Missile missile;
    
    public BoardCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.ship = null;
        this.missile = null;
    }
    
    public Ship getShip() {
        return ship;
    }
    public void setShip() {
	this.ship = new Ship(this);
    }
    
    public Missile getMissile() {
	return missile;
    }
	
    public void setMissile() {
        this.missile = new Missile(this);
    }
}
