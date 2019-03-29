package com.devsmms.mindgames.game.factories;

import com.devsmms.mindgames.game.players.GamePlayer;
import com.devsmms.mindgames.game.tables.GameTable;

public abstract class GameFactory {
    public abstract GameTable createTable();
    public abstract GamePlayer createPlayer();
}
