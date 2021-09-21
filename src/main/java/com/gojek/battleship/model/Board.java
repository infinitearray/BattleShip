/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gojek.battleship.model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author prabandi
 */
public class Board {
    private final int boardSize;
    private List<List<BoardCell>> boardCells;
    private List<List<Integer>> shipLocations;
    private List<List<Integer>> missileLocations;
    
    public Board(int boardSize) {
        this.boardSize = boardSize;
        //Initialise the board with the size
        boardCells = new ArrayList<List<BoardCell>>();
        for(int i=0;i<boardSize;i++){
            List<BoardCell> row = new ArrayList<BoardCell>();
            for(int j=0;j<boardSize;j++){
                    row.add(new BoardCell(i, j));
            }
            boardCells.add(row);
        }
        shipLocations = new ArrayList<List<Integer>>();
        missileLocations = new ArrayList<List<Integer>>();
    }
    
    public List<List<BoardCell>> getBoardCells() {
	return boardCells;
    }

    public void setBoardCells(List<List<BoardCell>> boardCells) {
	this.boardCells = boardCells;
    }

    public List<List<Integer>> getShipLocations() {
        return shipLocations;
    }

    public void setShipLocations(List<List<Integer>> shipLocations) {
        this.shipLocations = shipLocations;
    }

    public List<List<Integer>> getMissileLocations() {
        return missileLocations;
    }

    public void setMissileLocations(List<List<Integer>> missileLocations) {
        this.missileLocations = missileLocations;
    }
    
    public void setBoardItem(int x, int y, BoardItem item){
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(x);
        temp.add(y);
        if(item instanceof Ship){
            this.boardCells.get(x).get(y).setShip();
            this.shipLocations.add(temp);
        } else if(item instanceof Missile) {
            this.boardCells.get(x).get(y).setMissile();
            this.missileLocations.add(temp);
        }
    }
}
