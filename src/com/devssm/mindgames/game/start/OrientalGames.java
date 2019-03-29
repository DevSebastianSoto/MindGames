package com.devssm.mindgames.game.start;

public abstract class OrientalGames extends StartManager{

	@Override
	protected void initializeGameComponents() {
		initializeBags();
	}
	
	protected abstract void initializeBags();
}
