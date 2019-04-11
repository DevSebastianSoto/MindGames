package com.devsmms.mindgames.game.pieces.chess;

import com.devsmms.mindgames.game.enums.PieceColor;
import com.devsmms.mindgames.game.enums.PieceIcons;
import com.devsmms.mindgames.game.pieces.MotionPiece;
import com.devsmms.mindgames.game.pieces.Piece;

public class Pawn extends Piece implements MotionPiece {
	
	public Pawn(PieceColor color){
        this.color = color;
        this.icon = PieceIcons.PAWN;
    }
	
    @Override
    public int[][] calcMove (int coordX, int coordY) {
    	int[][] answer = {{1,0},{2,0},{1,1}, {1,-1}};
        return answer;
    }
}
