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
public class Missile extends BoardItem{
    private boolean isHit;
    
    public Missile(BoardCell boardCell){
        super(boardCell);
        this.isHit = false;
    }
    
    public boolean isHit() {
        return this.isHit;
    }

    public void setHit() {
        this.isHit = true;
    }
}
