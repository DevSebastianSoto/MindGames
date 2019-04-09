package com.devsmms.mindgames.ui.console;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.players.GamePlayer;
import com.devsmms.mindgames.ui.enums.Menu;

public class CheckersConsole extends GameConsole {
    public CheckersConsole() {
        super(GameTypes.CHECKERS);
    }

    @Override
    public boolean play() {
        return false;
    }

    @Override
    protected void printGreeting() {
        System.out.println("Bienvenido a Checkers");
    }

    @Override
    public void selectTurnMenuOption(GamePlayer player) {

    }


    @Override
    protected void printTurnMenu() {

    }
}
