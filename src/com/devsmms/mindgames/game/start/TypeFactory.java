package com.devsmms.mindgames.game.start;

import com.mindgames.game.games.Checkers;
import com.mindgames.game.games.Chess;
import com.mindgames.game.games.GO;
import com.mindgames.game.types.Types;

public class TypeFactory {
	
	public static StartManager getType(Types targetType) {

		switch (targetType) {
		case GO:
			return new GO();
		case CHESS:
			return new Chess();
		case CHECKERS:
			return new Checkers();
		default:
			throw new RuntimeException("Not Implemented");
		}
	}

}
