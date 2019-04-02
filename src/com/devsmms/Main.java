package com.devsmms;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.factories.FactoryGenerator;
import com.devsmms.mindgames.game.factories.GameFactory;
import com.devsmms.mindgames.game.players.GamePlayer;
import com.devsmms.mindgames.game.tables.GameTable;

public class Main {

	public static void main(String[] args) {

		GameFactory chessGameFactory = FactoryGenerator.getGameFactory(GameTypes.CHESS);
		GameTable chessTable = chessGameFactory.createTable();
		GamePlayer chessPlayer = chessGameFactory.createPlayer();

		System.out.println(chessTable.getTable().length);
		System.out.println(chessTable.getTable()[1].length);

		chessTable.getTable();
		chessPlayer.setNombre("Ricky");
		System.out.println(chessPlayer.getNombre());

		GameFactory checkersGameFactory = FactoryGenerator.getGameFactory(GameTypes.CHECKERS);
		GameTable checkersTable = checkersGameFactory.createTable();
		GamePlayer checkersPlayer = checkersGameFactory.createPlayer();
		
		System.out.println(checkersTable.getTable().length);
		System.out.println(checkersTable.getTable()[1].length);
		
	}
}
