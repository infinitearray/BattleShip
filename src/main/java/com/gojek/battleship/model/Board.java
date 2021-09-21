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
}
