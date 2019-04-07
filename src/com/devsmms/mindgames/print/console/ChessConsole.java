package com.devsmms.mindgames.print.console;

import com.devsmms.mindgames.game.controllers.ChessGameController;
import com.devsmms.mindgames.game.enums.GameTypes;

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
        String menu = "";
        menu += "+-----------------+\n";
        menu += "| 1. Elegir Pieza |\n";
        menu += "| 2. Salir        |\n";
        menu += "+-----------------+\n";
        menu += "Digite el número que corresponde a su juego deseado.";
        System.out.println(menu);
    }

    @Override
    public void printTurnMenu() {
    }

}
