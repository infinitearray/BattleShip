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
public class BoardItem {
    private BoardCell boardCell;
	
    public BoardItem(BoardCell boardCell) {
        this.boardCell = boardCell;
    }
}
