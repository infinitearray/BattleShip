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
    
    
}
