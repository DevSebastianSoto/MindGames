package com.devsmms.mindgames.game.players;

import com.devsmms.mindgames.game.pieces.Piece;
import com.devsmms.mindgames.game.tables.ChessTable;
import com.devsmms.mindgames.game.tables.GameTable;

public class CheckersPlayer extends GamePlayer implements MotionPiecePlayer {
    private int numeroCapturadas;

    public int getNumeroCapturadas() {
        return numeroCapturadas;
    }

    public void setNumeroCapturadas(int numeroCapturadas) {
        this.numeroCapturadas = numeroCapturadas;
    }

    @Override
    public void handleMotion(GameTable gTable, int prevX, int prevY, int postX, int postY) {
        Piece [][] table = gTable.getTable();
        table[postY][postX] = table[prevY][prevX];
        table[prevY][prevX] = null;
    }
}
