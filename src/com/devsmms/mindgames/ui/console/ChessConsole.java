package com.devsmms.mindgames.ui.console;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.players.GamePlayer;
import com.devsmms.mindgames.ui.enums.Menu;

public class ChessConsole extends GameConsole {

    public ChessConsole(){
        super(GameTypes.CHESS);
    }

    @Override
    public boolean play() {
        return false;
    }

    @Override
    protected void printGreeting() {
        System.out.println("Preparate para jugar Chess!");
    }

    @Override
    public void selectTurnMenuOption(GamePlayer player) {

    }

    @Override
    protected void printTurnMenu() {

    }
}
