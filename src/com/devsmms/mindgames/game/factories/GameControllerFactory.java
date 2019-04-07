package com.devsmms.mindgames.game.factories;

import com.devsmms.mindgames.game.controllers.CheckersGameController;
import com.devsmms.mindgames.game.controllers.ChessGameController;
import com.devsmms.mindgames.game.controllers.GameController;
import com.devsmms.mindgames.game.controllers.GoGameController;
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
