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
public class Ship extends BoardItem{
    private boolean isKilled;
    
    public Ship(BoardCell boardCell){
        super(boardCell);
        this.isKilled = false;
    }
    
    public boolean isKilled() {
        return this.isKilled;
    }

    public void setKilled() {
        this.isKilled = true;
    }
}
