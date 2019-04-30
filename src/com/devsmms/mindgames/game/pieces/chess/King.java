package com.devsmms.mindgames.game.pieces.chess;

import com.devsmms.mindgames.game.enums.PieceColor;
import com.devsmms.mindgames.game.enums.PieceIcons;
import com.devsmms.mindgames.game.pieces.MotionPiece;
import com.devsmms.mindgames.game.pieces.Piece;

public class King extends Piece implements MotionPiece {
    boolean alive;
	
	public King(PieceColor color){
        this.color = color;
        this.icon = PieceIcons.KING;
        this.alive = true;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    @Override
    public int[][] calcMove () {
    	int[][] answer = {{0,1},{0,-1},{1,0},{-1,0}, {1,1},{1,-1}, {-1,1}, {-1,-1}};
        return answer;
    }
}
