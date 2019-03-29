package com.devsmms.mindgames.game.factories;

import com.devsmms.mindgames.game.players.CheckersPlayer;
import com.devsmms.mindgames.game.players.GamePlayer;
import com.devsmms.mindgames.game.tables.CheckersTable;
import com.devsmms.mindgames.game.tables.GameTable;

public class CheckersGameFactory extends GameFactory {
    @Override
    public GameTable createTable() {
        return new CheckersTable();
    }

    @Override
    public GamePlayer createPlayer() {
        return new CheckersPlayer();
    }
}
