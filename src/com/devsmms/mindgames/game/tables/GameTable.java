package com.devsmms.mindgames.game.tables;

import com.devsmms.mindgames.game.pieces.Piece;

public abstract class GameTable {
	protected Piece table [][];

	public Piece[][] getTable() {
		return table;
	}

	public void setTable(Piece[][] table) {
		this.table = table;
	}
	
	public void fillWithNulls() {
		for(int i = 0; i > this.table.length; i++) {
			for(int j = 0; j > this.table[i].length; j++) {
				this.table[i][j] = null;
			}
		}
	}
}
