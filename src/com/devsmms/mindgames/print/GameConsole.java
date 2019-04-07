package com.devsmms.mindgames.print;

import com.devsmms.mindgames.game.controllers.GameController;
import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.factories.GameControllerFactory;

public abstract class GameConsole {

    private GameTypes type;
    private GameController controller;

    public void start(){
        type = selectGame();
        controller = GameControllerFactory.getGameController(type);

    }

    public void play(){

    }

    public abstract GameTypes selectGame();
    public abstract int showMainMenu();
    public abstract int showTurnMenu();

}
