package com.devsmms.mindgames.game.pieces.chess;

import com.devsmms.mindgames.game.enums.PieceColor;
import com.devsmms.mindgames.game.enums.PieceIcons;
import com.devsmms.mindgames.game.pieces.MotionPiece;
import com.devsmms.mindgames.game.pieces.Piece;

public class Knight extends Piece implements MotionPiece {
	
	public Knight(PieceColor color){
        this.color = color;
        this.icon = PieceIcons.KNIGHT;
    }
	
    @Override
    public int[][] calcMove (int coordX, int coordY) {
    	int[][] answer = {{2,1}, {2,-1}, {-2,1}, {-2,-1}, {1,2}, {-1,2}, {1,-2}, {-1,-2}};
        return answer;
    }
}
