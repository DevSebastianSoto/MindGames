package com.devsmms.mindgames.print.factory;

import com.devsmms.mindgames.game.CheckersGameController;
import com.devsmms.mindgames.game.ChessGameController;
import com.devsmms.mindgames.game.GameController;
import com.devsmms.mindgames.game.GoGameController;
import com.devsmms.mindgames.game.enums.GameTypes;

public class GameControllerFactory {
    public static GameController getGameController(GameTypes type) {
        switch (type) {
            case CHECKERS:
                return new CheckersGameController();
            case GO:
                return new GoGameController();
            case CHESS:
                return new ChessGameController();
            default:
                throw new RuntimeException("Invalid option");
        }
    }
}
