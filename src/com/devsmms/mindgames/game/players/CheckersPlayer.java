package com.devsmms.mindgames.game.players;

public class CheckersPlayer extends GamePlayer implements MotionPiecePlayer {
	private int numeroCapturadas;

	public int getNumeroCapturadas() {
		return numeroCapturadas;
	}

	public void setNumeroCapturadas(int numeroCapturadas) {
		this.numeroCapturadas = numeroCapturadas;
	}

	@Override
	public boolean handleMotion(int prevX, int prevY, int postX, int postY) {
		return false;
	}
}
