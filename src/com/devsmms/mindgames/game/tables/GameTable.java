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
        col = (char) (65 - (int) col);
        if (col > -1 && row > -1)
            return new int[]{col, row};
        else
            return null;
    }
}
