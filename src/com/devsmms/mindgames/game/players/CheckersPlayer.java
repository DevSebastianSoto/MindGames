package com.devsmms.mindgames.game.players;

import com.devsmms.mindgames.game.pieces.Piece;

public class CheckersPlayer extends GamePlayer implements MotionPiecePlayer {
    private int numeroCapturadas;

    public int getNumeroCapturadas() {
        return numeroCapturadas;
    }

    public void setNumeroCapturadas(int numeroCapturadas) {
        this.numeroCapturadas = numeroCapturadas;
    }

    @Override
    public boolean handleMotion(Piece[][] table, int prevX, int prevY, int postX, int postY) {
        Piece p = table[prevY][prevX];
        Piece futurePiecePosition = table[postY][postX];
        Piece aux = p;

        if(futurePiecePosition == null){
            table[postY][postX] = p;
        }

        table[prevY][prevX] = null;
        return true;
    }
}
