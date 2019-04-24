package com.devsmms.mindgames.game.tables;

import java.util.ArrayList;

public interface MotionPieceTable{
	abstract ArrayList<ArrayList<Integer>> suggestMove(int x, int y);
	public void initTableWithPieces();
	
}
