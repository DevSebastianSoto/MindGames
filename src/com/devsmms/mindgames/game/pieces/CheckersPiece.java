package com.devsmms.mindgames.game.pieces;

import com.devsmms.mindgames.game.enums.PieceIcons;

public class CheckersPiece extends Piece implements MotionPiece {

    public CheckersPiece() {
        this.icon = PieceIcons.CHECKERS_NORMAL;
    }

	@Override
	public int[][] calcMove(int coordX, int coordY) {
		int[][] answer = { { 1, 1 }, { 2, 2 }, { 1, -1 }, { 2, -2 } };
		return answer;
	}
}