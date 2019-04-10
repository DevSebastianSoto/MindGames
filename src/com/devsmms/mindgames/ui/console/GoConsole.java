package com.devsmms.mindgames.ui.console;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.players.GamePlayer;
import com.devsmms.mindgames.ui.enums.Menu;

import java.io.IOException;

public class GoConsole extends GameConsole {

    public GoConsole() {
        super(GameTypes.GO, "Preparate para jugar GO!");
    }

    @Override
    public void selectTurnMenuOption(GamePlayer player) {
        displayTurnDefaulInformation(player.getName());
        try {
            Console.leer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void printTurnMenu() {
        System.out.println("Jugador juega jugando checkers");
    }

    @Override
    public void printTable() {

    }
}
