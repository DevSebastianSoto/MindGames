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
    	int[][] answer = {{0,1},{0,2},{1,1}, {1,-1}};
    	//ToDo en el caso de 0,2 el tablero valida si es la primer vez que se mueve el peon
        return answer;
    }
}
