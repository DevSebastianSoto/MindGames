package com.devsmms.mindgames.game.players;

import com.devsmms.mindgames.game.pieces.Piece;

public class ChessPlayer extends GamePlayer {
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
	
	public void movePiece() {
		
	}
	
}
