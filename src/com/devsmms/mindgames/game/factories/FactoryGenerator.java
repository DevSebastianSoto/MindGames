package com.devsmms.mindgames.game.factories;

import com.devsmms.mindgames.game.Types;

public class FactoryGenerator {
    public static GameFactory getGameFactory(Types type) {
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
