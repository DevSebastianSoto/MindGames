package com.devsmms.mindgames.game.tables;

import com.devsmms.mindgames.game.pieces.Piece;

public class CheckersTable extends GameTable implements MotionPieceTable {

	
	public CheckersTable() {
		this.table = new Piece[10][10];
	}
	
	@Override
	public void suggestMove() {
		// TODO Auto-generated method stub
		
	}
}
