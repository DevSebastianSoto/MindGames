package com.devsmms.mindgames.game.players;

import com.devsmms.mindgames.game.pieces.Piece;

public class ChessPlayer extends GamePlayer implements MotionPiecePlayer{
	private Piece capturadas [];
	private int points;
	
	public Piece[] getCapturadas() {
		return capturadas;
	}
	
	public void setCapturadas(Piece[] capturadas) {
		this.capturadas = capturadas;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public boolean handleMotion(int prevX, int prevY, int postX, int postY) {
		return false;
	}
}
