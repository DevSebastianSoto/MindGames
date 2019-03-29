package com.devssm.mindgames.game.start;

public abstract class StartManager {

	public void gameStart() {

		printInitialBoard();
		initializeGameComponents();
	}

	protected abstract void printInitialBoard();

	protected abstract void initializeGameComponents();
	
}
