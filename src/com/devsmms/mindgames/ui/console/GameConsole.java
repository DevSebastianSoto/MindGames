package com.devsmms.mindgames.ui.console;

import com.devsmms.mindgames.game.controllers.GameController;
import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.factories.GameControllerFactory;
import com.devsmms.mindgames.game.pieces.Piece;
import com.devsmms.mindgames.game.players.GamePlayer;
import com.devsmms.mindgames.ui.enums.Menu;

import java.io.IOException;

public abstract class GameConsole {

    private boolean running;
    protected GameController controller;

    GameConsole(GameTypes type){
        controller = GameControllerFactory.getGameController(type);
    }

    public void selectMainMenuOption() {
        boolean validOption = false;
        while(!validOption){
            printMainMenu();
            try {
                int option = Integer.parseInt(Console.leer.readLine());
                switch (option) {
                    case 1:
                        begin();
                        validOption = true;
                        break;
                    case 2:
                        Console.getInstance().start();
                        validOption = true;
                        break;
                    default:
                        System.out.println("Esa opcion no es valida");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor digite un numero");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void printMainMenu() {
        System.out.println(Menu.START_GAME_OPTIONS.getText());
    }

    protected void setUpPlayers(){
        try {
            String p1,p2 ;
            System.out.println("Primer jugador:");
            System.out.println(Menu.SET_PLAYER_NAME.getText());
            p1 = Console.leer.readLine();
            System.out.println("Segundo jugador:");
            System.out.println(Menu.SET_PLAYER_NAME.getText());
            p2 = Console.leer.readLine();
            controller.setUpPlayers(p1,p2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void printTable(){
        Piece [][] table = this.controller.getGameTable().getTable();
    }

    public void begin(){
        System.out.println();
        printGreeting();
        System.out.println();
        setUpPlayers();
        play();
    }

    public abstract boolean play();
    public abstract void selectTurnMenuOption(GamePlayer player);
    protected abstract void printGreeting();
    protected abstract void printTurnMenu();

}
