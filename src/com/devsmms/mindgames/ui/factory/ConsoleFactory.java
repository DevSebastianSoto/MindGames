package com.devsmms.mindgames.ui.factory;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.ui.console.CheckersConsole;
import com.devsmms.mindgames.ui.console.ChessConsole;
import com.devsmms.mindgames.ui.console.GameConsole;
import com.devsmms.mindgames.ui.console.GoConsole;

public class ConsoleFactory {
    public static GameConsole getConsole(GameTypes type){
        switch (type) {
            case CHECKERS:
                return new CheckersConsole();
            case GO:
                return new GoConsole();
            case CHESS:
                return new ChessConsole();
            default:
                throw new RuntimeException("Invalid Option");
        }
    }
}
