package com.devsmms.mindgames.game.tables;

import com.devsmms.mindgames.game.pieces.Piece;

public class ChessTable extends GameTable implements MotionPieceTable {

	
	public ChessTable() {
		this.table = new Piece[8][8];
	}
	
	@Override
	public void suggestMove() {
		// TODO Auto-generated method stub
		
	}

	
}
