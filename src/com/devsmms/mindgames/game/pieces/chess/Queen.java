package com.devsmms.mindgames.game.pieces.chess;

import com.devsmms.mindgames.game.enums.PieceColor;
import com.devsmms.mindgames.game.enums.PieceIcons;
import com.devsmms.mindgames.game.pieces.MotionPiece;
import com.devsmms.mindgames.game.pieces.Piece;

public class Queen extends Piece implements MotionPiece {
	
	public Queen(PieceColor color){
        this.color = color;
        this.icon = PieceIcons.QUEEN;
    }
	
    @Override
    public int[][] calcMove (int coordX, int coordY) {
    	int[][] answer =   {{0,1},{0,2},{0,3},{0,4},{0,5},{0,6},{0,7},
				{0,-1},{0,-2},{0,-3},{0,-4},{0,-5},{0,-6},{0,-7},
				{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{7,0},
				{-1,0},{-2,0},{-3,0},{-4,0},{-5,0},{-6,0},{-7,0},
				
				{1,1},{2,2},{3,3},{4,4},{5,5},{6,6},{7,7},
				{1,-1},{2,-2},{3,-3},{4,-4},{5,-5},{6,-6},{7,-7},
				{-1,1},{-2,2},{-3,3},{-4,4},{-5,5},{-6,6},{-7,7},
				{-1,-1},{-2,-2},{-3,-3},{-4,-4},{-5,-5},{-6,-6},{-7,-7}};
    	return answer;
    }
}
