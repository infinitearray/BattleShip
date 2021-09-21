/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gojek.battleship.model;

import java.util.List;

/**
 *
 * @author prabandi
 */
public class Player {
    private final String id;
    private Board board;
    private int numKills;
    private int numShips;
    private int numMissiles;
    
    public Player(Board board, String id) {
        this.id = id;
        this.board = board;
        this.numKills = 0;
        this.numShips = 0;
        this.numMissiles = 0;
    }
    
    public String getId() {
        return id;
    }
    
    public Board getBoard() {
        return board;
    }

    public int getKills() {
        return this.numKills;
    }
    
    public void addKill() {
        this.numKills++;
    }

    public int getNumShips() {
        return numShips;
    }

    public void setNumShips(int numShips) {
        this.numShips = numShips;
    }

    public int getNumMissiles() {
        return numMissiles;
    }

    public void setNumMissiles(int numMissiles) {
        this.numMissiles = numMissiles;
    }
    
    public void setShipLocations(List<List<Integer>> shipLocations) {
        for(List<Integer> eachShip : shipLocations){
            int x = eachShip.get(0);
            int y = eachShip.get(1);
            this.board.setBoardItem(x, y, BoardItemType.SHIP);
            numShips++;
        }
    }
	
    public void setMissileLocations(List<List<Integer>> missileLocations) {
        for(List<Integer> eachMissile : missileLocations){
            int x = eachMissile.get(0);
            int y = eachMissile.get(1);
            this.board.setBoardItem(x, y, BoardItemType.MISSILE);
            this.numMissiles++;
        }
    }
    
}
