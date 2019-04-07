package com.devsmms.mindgames.game.factories;

import com.devsmms.mindgames.game.enums.GameTypes;

public class GameFactoryGenerator {
    public static GameFactory getGameFactory(GameTypes type) {
        switch (type) {
            case CHECKERS:
                return new CheckersGameFactory();
            case GO:
                return new GoGameFactory();
            case CHESS:
                return new ChessGameFactory();
            default:
                throw new RuntimeException("Invalid Option");
        }
    }
}
