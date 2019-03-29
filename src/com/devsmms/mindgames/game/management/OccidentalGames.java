package com.devsmms.mindgames.game.management;

public abstract class OccidentalGames extends GameManager{
	
	@Override
	protected void initializeGameComponents() {
		initializePieces();
		initializePlayers();
	}
	
	
	
	protected abstract void initializePieces();
	
	protected abstract void initializePlayers();

}
