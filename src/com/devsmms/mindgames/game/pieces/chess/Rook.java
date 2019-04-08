package com.devsmms.mindgames.game.pieces.chess;

import com.devsmms.mindgames.game.enums.PieceColor;
import com.devsmms.mindgames.game.enums.PieceIcons;
import com.devsmms.mindgames.game.pieces.MotionPiece;
import com.devsmms.mindgames.game.pieces.Piece;

public class Rook extends Piece implements MotionPiece {
	
	public Rook(PieceColor color){
        this.color = color;
        this.icon = PieceIcons.ROOK.getTabbedIcon();
    }
	
    @Override
    public int[][] calcMove (int coordX, int coordY) {
    	int[][] answer =   {{0,1},{0,2},{0,3},{0,4},{0,5},{0,6},{0,7},
    						{0,-1},{0,-2},{0,-3},{0,-4},{0,-5},{0,-6},{0,-7},
    						{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{7,0},
    						{-1,0},{-2,0},{-3,0},{-4,0},{-5,0},{-6,0},{-7,0}};
        return answer;
    }
}
