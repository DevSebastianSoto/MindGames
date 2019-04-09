package com.devsmms.mindgames.ui.console;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.players.GamePlayer;
import com.devsmms.mindgames.ui.enums.Menu;

import java.io.IOException;

public class GoConsole extends GameConsole {

    public GoConsole() {
        super(GameTypes.GO);
    }

    @Override
    public boolean play() {
        int turnCounter = 0;
        while(controller.getWinner() == null){
            GamePlayer player = (turnCounter % 2 == 0)? controller.getP1():controller.getP2();
            selectTurnMenuOption(player);
            turnCounter++;
//            ToDo hacer play un template y optimizar este codigo
        }
        return true;
    }

    @Override
    protected void printGreeting() {
        System.out.println("Preparate para jugar GO!");
    }

    @Override
    public void selectTurnMenuOption(GamePlayer player) {
        printTable();
        System.out.println("Es el turno de:\t"+player.getName());
        printTurnMenu();
        try {
            Console.leer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void printTurnMenu() {
        System.out.println("Jugador juega jugando jugador");
    }
}
