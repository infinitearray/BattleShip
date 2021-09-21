/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gojek.battleship.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

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
        Board board1 = null;
	Board board2 = null;
        try {
            File input = new File(inputFile);
            //Read the file contents
            BufferedReader br = new BufferedReader(new FileReader(input));
            //board size
            String nextLine = br.readLine();
            this.boardSize = Integer.parseInt(nextLine);
            board1 = new Board(this.boardSize);
            board2 = new Board(this.boardSize);
            //number of ships
            nextLine = br.readLine();
            int numShips = Integer.parseInt(nextLine);
            //Player1 ships
            nextLine = br.readLine();
            String[] ships1 = nextLine.split(":");
            for(String ship : ships1) {
                String[] locs = ship.split(",");
                int x = Integer.parseInt(locs[0]);
                int y = Integer.parseInt(locs[1]);
                board1.setBoardItem(x, y, BoardItemType.SHIP);
            }
            //Player2 ships
            nextLine = br.readLine();
            String[] ships2 = nextLine.split(":");
            for(String ship : ships2) {
                String[] locs = ship.split(",");
                int x = Integer.parseInt(locs[0]);
                int y = Integer.parseInt(locs[1]);
                board2.setBoardItem(x, y, BoardItemType.SHIP);
            }	
            // number of missiles
            nextLine = br.readLine();
            int numMissiles = Integer.parseInt(nextLine);
            //Player1 missiles
            nextLine = br.readLine();
            String[] missile1 = nextLine.split(":");
            for(String missile : missile1) {
                String[] locs = missile.split(",");
                int x = Integer.parseInt(locs[0]);
                int y = Integer.parseInt(locs[1]);
                board1.setBoardItem(x, y, BoardItemType.MISSILE);
            }
            //Player2 missiles
            nextLine = br.readLine();
            String[] missile2 = nextLine.split(":");
            for(String missile : missile2) {
                String[] locs = missile.split(",");
                int x = Integer.parseInt(locs[0]);
                int y = Integer.parseInt(locs[1]);
                board2.setBoardItem(x, y, BoardItemType.MISSILE);
            }
            
            
            //Players
            this.player1 = new Player(board1, "P1");
            this.player2 = new Player(board2, "P2");
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
        
        //for each missile of Player1
        for(List<Integer> missileLoc : board1.getMissileLocations()) {
            int x = missileLoc.get(0);
            int y = missileLoc.get(1);
            BoardCell curCell1 = board1.getBoardCells().get(x).get(y);
            BoardCell curCell2 = board2.getBoardCells().get(x).get(y);
            
            Missile curMissile1 = curCell1.getMissile();
            Ship curShip2 = curCell2.getShip();
            if(curShip2 != null) {
                //Kill the ship
                curShip2.setKilled();
                curMissile1.setHit();
                player1.addKill();
            }
        }
        
        //for each missile of Player2
        for(List<Integer> missileLoc : board2.getMissileLocations()) {
            int x = missileLoc.get(0);
            int y = missileLoc.get(1);
            BoardCell curCell1 = board1.getBoardCells().get(x).get(y);
            BoardCell curCell2 = board2.getBoardCells().get(x).get(y);
            
            Missile curMissile2 = curCell2.getMissile();
            Ship curShip1 = curCell1.getShip();
            if(curShip1 != null) {
                //Kill the ship
                curShip1.setKilled();
                curMissile2.setHit();
                player2.addKill();
            }
        }
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
            List<List<BoardCell>> boardCells1 = player1.getBoard().getBoardCells();
            List<List<BoardCell>> boardCells2 = player2.getBoard().getBoardCells();
            
            System.out.println("Player1");
            
            for(int x=0;x<boardSize;x++) {
                for(int y=0;y<boardSize;y++) {
                    BoardCell curCell1 = boardCells1.get(x).get(y);
                    Ship curShip = curCell1.getShip();
                    BoardCell curCell2 = boardCells2.get(x).get(y);
                    Missile curMissile = curCell2.getMissile();
                    if(curShip!= null) {
                        if(curShip.isKilled())
                            System.out.print("X");
                        else
                            System.out.print("B");
                    }
                    else if(curMissile != null) {
                        if(!curMissile.isHit())
                            System.out.print("O");
                        else
                            System.out.print("_");
                    }
                    else {
                        System.out.print("_");
                    }
                }
                System.out.println("\n");
            }
            
            System.out.println("Player2");
            for(int x=0;x<boardSize;x++) {
                for(int y=0;y<boardSize;y++) {
                    BoardCell curCell2 = boardCells2.get(x).get(y);
                    Ship curShip = curCell2.getShip();
                    BoardCell curCell1 = boardCells1.get(x).get(y);
                    Missile curMissile = curCell1.getMissile();
                    if(curShip!= null) {
                        if(curShip.isKilled())
                            System.out.print("X");
                        else
                            System.out.print("B");
                    }
                    else if(curMissile != null) {
                        if(!curMissile.isHit())
                            System.out.print("O");
                        else
                            System.out.print("_");
                    }
                    else {
                        System.out.print("_");
                    }
                }
                System.out.println("\n");
            }
            
            int p1Kills = player1.getKills();
            int p2Kills = player2.getKills();
            System.out.println("P1: "+p1Kills);
            System.out.println("P2: "+p2Kills);
            
            int p1Ships = player1.getNumShips();
            int p2Ships = player2.getNumShips();
            if(p1Kills == p2Ships){
                System.out.println("Player1 wins");
            }
            else if(p2Kills == p1Ships) {
                System.out.println("Player2 wins");
            }
            else if(p1Kills == p2Kills){
                System.out.println("It is a draw");
            } 
            else if(p1Kills > p2Kills){
                System.out.println("Player1 wins");
            }
            else {
                System.out.println("Player2 wins");
            }
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
