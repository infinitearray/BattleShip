/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gojek.battleship;

import com.gojek.battleship.model.BattleShipService;

/**
 *
 * @author prabandi
 */
public class BattleShip {
    public static void main(String[] args) {
        //Main method
        BattleShipService game = new BattleShipService(Constants.inputFilePath);
        game.startBattle();
        game.finishBattle(Constants.outputFilePath);
    }
}
