package com.devssm.mindgames.game.start;

public abstract class OccidentalGames extends StartManager{
	
	@Override
	protected void initializeGameComponents() {
		initializePieces();
		initializePlayers();
	}
	
	
	
	protected abstract void initializePieces();
	
	protected abstract void initializePlayers();

}
