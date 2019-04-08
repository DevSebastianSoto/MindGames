package com.devsmms.mindgames.ui.console;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.ui.enums.Menu;

public class ChessConsole extends GameConsole {

    public ChessConsole(){
        super(GameTypes.CHESS);
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
        System.out.println(Menu.BASIC_TURN_OPTIONS);
    }

}
