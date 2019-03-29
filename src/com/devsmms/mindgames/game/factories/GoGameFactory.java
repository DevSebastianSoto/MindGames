package com.devsmms.mindgames.game.factories;

import com.devsmms.mindgames.game.players.GamePlayer;
import com.devsmms.mindgames.game.players.GoPlayer;
import com.devsmms.mindgames.game.tables.GameTable;
import com.devsmms.mindgames.game.tables.GoTable;

public class GoGameFactory extends GameFactory {
    @Override
    public GameTable createTable() {
        return new GoTable();
    }

    @Override
    public GamePlayer createPlayer() {
        return new GoPlayer();
    }
}
