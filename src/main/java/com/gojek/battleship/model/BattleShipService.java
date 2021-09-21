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
public class BattleShipService {
    //The main class that starts the game play
    private Player player1;
    private Player player2;
    private int boardSize;
    
    public BattleShipService(Player player1, Player player2, int boardSize) {
        this.player1 = player1;
        this.player2 = player2;
        this.boardSize = boardSize;
    }
    
    public Player getPlayer1() {
        return player1;
    }
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }
    public Player getPlayer2() {
        return player2;
    }
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }
    
    public void startBattle() {
        //start the game
    }
    
    public void finishBattle() {
        // give the output result
    }
}
