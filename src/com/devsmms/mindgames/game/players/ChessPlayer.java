package com.devsmms.mindgames.game.players;

import com.devsmms.mindgames.game.pieces.Piece;
import com.devsmms.mindgames.game.tables.GameTable;

public class ChessPlayer extends GamePlayer implements MotionPiecePlayer {
    private Piece capturadas[];
    private int points;

    public Piece[] getCapturadas() {
        return capturadas;
    }

    public void setCapturadas(Piece[] capturadas) {
        this.capturadas = capturadas;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


    @Override
    public void handleMotion(GameTable gTable, int prevX, int prevY, int postX, int postY) {

    }
}
