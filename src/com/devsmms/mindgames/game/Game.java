package com.devsmms.mindgames.game;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.factories.FactoryGenerator;
import com.devsmms.mindgames.game.factories.GameFactory;
import com.devsmms.mindgames.game.players.GamePlayer;
import com.devsmms.mindgames.game.tables.GameTable;

public class Game {
    public final GameTable table;
    public final GamePlayer p1;
    public final GamePlayer p2;

    protected Game(GameTypes target) {
        GameFactory gameFactory = FactoryGenerator.getGameFactory(target);
        p1 = gameFactory.createPlayer();
        p2 = gameFactory.createPlayer();
        table = gameFactory.createTable();
    }

    public GameTable getTable() {
        return table;
    }

    public GamePlayer getP1() {
        return p1;
    }

    public GamePlayer getP2() {
        return p2;
    }


}
