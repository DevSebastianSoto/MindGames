package com.devsmms.mindgames.game.pieces.chess;

import com.devsmms.mindgames.game.enums.PieceColor;
import com.devsmms.mindgames.game.enums.PieceIcons;
import com.devsmms.mindgames.game.pieces.MotionPiece;
import com.devsmms.mindgames.game.pieces.Piece;

public class Pawn extends Piece implements MotionPiece {
    boolean firstTurn;
	
	public Pawn(PieceColor color){
        this.color = color;
        this.icon = PieceIcons.PAWN;
        this.firstTurn = true;
    }

    public boolean isFirstTurn() {
        return firstTurn;
    }

    public void setFirstTurn(boolean firstTurn) {
        this.firstTurn = firstTurn;
    }


    @Override
    public int[][] calcMove () {
        int[][] answer = {{0,1},{0,2},{0,-1},{0,-2},{1,-1},{1,1},{-1,-1},{-1,1}};
        return answer;
    }
}
