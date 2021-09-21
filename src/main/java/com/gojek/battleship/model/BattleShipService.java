/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gojek.battleship.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
/**
 *
 * @author prabandi
 */
public class BattleShipService {
    //The main class that starts the game play
    private Player player1;
    private Player player2;
    private int boardSize;
    
    
    public BattleShipService(String inputFile) {
        initSetup(inputFile);
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
    
    public void initSetup(String inputFile) {
        //Read the files and do the initial setup
        try {
            File input = new File(inputFile);
            //Read the file contents
        }
        catch(Exception e) {
            System.out.println("Unable to initalise the setup!");
            e.printStackTrace();
        }
    }
    
    public void startBattle() {
        //start the game
        Board board1 = this.player1.getBoard();
        Board board2 = this.player2.getBoard();
        
    }
    
    public void finishBattle(String outputFile) {
        // give the output result
        PrintStream ps_console = System.out;    
        try {
            File file = new File(outputFile);
            FileOutputStream fos = new FileOutputStream(file);

            // Create new print stream for file.
            PrintStream ps = new PrintStream(fos);
		
            // Set file print stream.
            System.setOut(ps);
            //write the output
            System.setOut(ps_console);
	}
	catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            System.setOut(ps_console);
        }
    }
}
