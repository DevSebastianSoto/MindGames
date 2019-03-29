package com.devsmms.mindgames.game.management;

public abstract class OrientalGames extends GameManager{

	@Override
	protected void initializeGameComponents() {
		initializeBags();
	}
	
	protected abstract void initializeBags();
}
