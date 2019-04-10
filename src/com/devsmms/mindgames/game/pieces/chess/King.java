package com.devsmms.mindgames.game.pieces.chess;

import com.devsmms.mindgames.game.enums.PieceColor;
import com.devsmms.mindgames.game.enums.PieceIcons;
import com.devsmms.mindgames.game.pieces.MotionPiece;
import com.devsmms.mindgames.game.pieces.Piece;

public class King extends Piece implements MotionPiece {
	
	public King(PieceColor color){
        this.color = color;
        this.icon = PieceIcons.KING;
    }
	
    @Override
    public int[][] calcMove (int coordX, int coordY) {
    	int[][] answer = {{0,1},{0,-1},{1,0},{-1,0}};
    	//ToDo agregar las diagonales al movimiento del rey
        return answer;
    }
}
