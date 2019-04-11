package com.devsmms.mindgames.game.pieces;

public class CheckersPiece extends Piece implements MotionPiece {

	public CheckersPiece() {

	}

	@Override
	public int[][] calcMove(int coordX, int coordY) {
		int[][] answer = { { 1, 1 }, { 2, 2 }, { 1, -1 }, { 2, -2 } };
		return answer;
	}
}