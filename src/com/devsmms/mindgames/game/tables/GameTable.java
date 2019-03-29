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
}
