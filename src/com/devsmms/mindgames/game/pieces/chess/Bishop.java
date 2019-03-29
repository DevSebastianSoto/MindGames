package com.devsmms.mindgames.game.pieces.chess;

import com.devsmms.mindgames.game.enums.PieceColor;
import com.devsmms.mindgames.game.enums.PieceIcons;
import com.devsmms.mindgames.game.pieces.MotionPiece;
import com.devsmms.mindgames.game.pieces.Piece;

public class Bishop extends Piece implements MotionPiece {

    public Bishop(PieceColor color){
        this.color = color;
        this.icon = PieceIcons.BISHOP.getTabbedIcon();
    }

    @Override
    public int[][] calcMove() {
        return new int[0][];
    }
}
