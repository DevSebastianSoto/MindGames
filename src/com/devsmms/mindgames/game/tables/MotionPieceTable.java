package com.devsmms.mindgames.game.tables;

import java.util.ArrayList;

public interface MotionPieceTable{
	ArrayList<ArrayList<Integer>> suggestMove(int x, int y);
	void initTableWithPieces();
	
}
