package com.devsmms.mindgames.game.pieces.chess;

import com.devsmms.mindgames.game.enums.PieceColor;
import com.devsmms.mindgames.game.enums.PieceIcons;
import com.devsmms.mindgames.game.pieces.MotionPiece;
import com.devsmms.mindgames.game.pieces.Piece;

public class Queen extends Piece implements MotionPiece {
	
	public Queen(PieceColor color){
        this.color = color;
        this.icon = PieceIcons.QUEEN.getTabbedIcon();
    }
	
    @Override
    public int[][] calcMove (int coordX, int coordY) {
        return new int[0][];
    }
}
