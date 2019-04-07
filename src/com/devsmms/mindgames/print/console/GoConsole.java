package com.devsmms.mindgames.print.console;

import com.devsmms.mindgames.game.enums.GameTypes;

public class GoConsole extends GameConsole {

    public GoConsole() {
        super(GameTypes.GO);
    }
    @Override
    public GameTypes selectGame() {
        return null;
    }

    @Override
    public void printMainMenu() {
    }

    @Override
    public void printTurnMenu() {
    }

}
