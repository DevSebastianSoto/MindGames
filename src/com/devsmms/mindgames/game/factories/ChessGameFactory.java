package com.devsmms.mindgames.game.factories;

import com.devsmms.mindgames.game.players.ChessPlayer;
import com.devsmms.mindgames.game.players.GamePlayer;
import com.devsmms.mindgames.game.tables.ChessTable;
import com.devsmms.mindgames.game.tables.GameTable;

public class ChessGameFactory extends GameFactory {
    @Override
    public GameTable createTable() {
        return new ChessTable();
    }

    @Override
    public GamePlayer createPlayer() {
        return new ChessPlayer();
    }
}
