package com.devsmms.mindgames.game.tables;

import com.devsmms.mindgames.game.pieces.Piece;

public abstract class GameTable {
    protected Piece table[][];

    public Piece[][] getTable() {
        return table;
    }

    public void setTable(Piece[][] table) {
        this.table = table;
    }

    public int[] translateCoords(char col, int row) {
        row = this.table.length - row;
        int column = ((int) col - 65);
        if (column > -1 && row > -1)
            return new int[]{column, row};
        else
            return null;
    }
}
