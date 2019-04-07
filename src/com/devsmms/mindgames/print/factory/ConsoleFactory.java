package com.devsmms.mindgames.print.factory;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.print.console.CheckersConsole;
import com.devsmms.mindgames.print.console.ChessConsole;
import com.devsmms.mindgames.print.console.GameConsole;
import com.devsmms.mindgames.print.console.GoConsole;

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
