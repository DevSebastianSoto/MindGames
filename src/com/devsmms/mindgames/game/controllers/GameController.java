package com.devsmms.mindgames.game.controllers;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.factories.GameFactoryGenerator;
import com.devsmms.mindgames.game.factories.GameFactory;
import com.devsmms.mindgames.game.players.GamePlayer;
import com.devsmms.mindgames.game.tables.GameTable;

public abstract class GameController {
    private final GameTable gameTable;
    private final GamePlayer p1;
    private final GamePlayer p2;
    private GamePlayer winner;

    GameController(GameTypes target) {
        GameFactory gameFactory = GameFactoryGenerator.getGameFactory(target);
        p1 = gameFactory.createPlayer();
        p2 = gameFactory.createPlayer();
        gameTable = gameFactory.createTable();
        winner = null;
    }

    public GameTable getGameTable() {
        return gameTable;
    }

    public GamePlayer getP1() {
        return p1;
    }

    public GamePlayer getP2() {
        return p2;
    }

    public GamePlayer getWinner() { return winner; }

}
