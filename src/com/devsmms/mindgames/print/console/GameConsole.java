package com.devsmms.mindgames.print.console;

import com.devsmms.mindgames.game.controllers.GameController;
import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.factories.GameControllerFactory;

public abstract class GameConsole {

    private boolean running;
    protected GameController controller;

    GameConsole(GameTypes type){
        GameController controller = GameControllerFactory.getGameController(type);
    }

    public void play(){

    }

    public abstract GameTypes selectGame();
    public abstract void printMainMenu();
    public abstract void printTurnMenu();

}
