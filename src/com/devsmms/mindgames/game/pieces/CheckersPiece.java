package com.devsmms.mindgames.game.pieces;

import com.devsmms.mindgames.game.enums.PieceIcons;

public class CheckersPiece extends Piece implements MotionPiece {

    public CheckersPiece() {
        this.icon = PieceIcons.CHECKERS_NORMAL;
    }

    @Override
    public int[][] calcMove (int coordX, int coordY) {
        return new int[0][];
    }
}
