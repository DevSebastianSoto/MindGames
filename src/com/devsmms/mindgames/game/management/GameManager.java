package com.devsmms.mindgames.game.management;

public abstract class GameManager {

	public void gameStart() {

		printInitialBoard();
		initializeGameComponents();
	}

	protected abstract void printInitialBoard();

	protected abstract void initializeGameComponents();
	
}
