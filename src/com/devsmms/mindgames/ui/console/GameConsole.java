package com.devsmms.mindgames.ui.console;

import com.devsmms.mindgames.game.controllers.GameController;
import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.factories.GameControllerFactory;
import com.devsmms.mindgames.game.pieces.Piece;
import com.devsmms.mindgames.game.players.GamePlayer;
import com.devsmms.mindgames.ui.enums.Color;
import com.devsmms.mindgames.ui.enums.Menu;
import com.devsmms.mindgames.ui.print.ColorPrinter;

import java.io.IOException;

public abstract class GameConsole {

    protected final String GREETING;
    protected GameController controller;

    protected final Color black, white, background;
    protected final ColorPrinter textHighlighter;
    protected final ColorPrinter numberHighlighter;
    private boolean running;
    private int turnCounter;

    GameConsole(GameTypes type, String greeting) {
        controller = GameControllerFactory.getGameController(type);
        this.GREETING = greeting;
        this.turnCounter = 0;
        this.black = Color.MAGENTA;
        this.white = Color.YELLOW;
        this.background = Color.BLUE;
        this.textHighlighter = (new ColorPrinter.PrinterBuilder()).withBrightness(false).withTextColor(Color.CYAN).build();
        this.numberHighlighter = (new ColorPrinter.PrinterBuilder()).withBrightness(true).withTextColor(Color.MAGENTA).build();
    }

    private void printMainMenu() {
        System.out.println(Menu.START_GAME_OPTIONS.getText());
    }

    public void selectMainMenuOption() {
        boolean validOption = false;
        while (!validOption) {
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

    public void begin() {
        System.out.println("\n" + this.GREETING + "\n");
        setUpPlayers();
        play();
    }

    protected void setUpPlayers() {
        try {
            String p1, p2;
            System.out.println(textHighlighter.getFormattedString("Primer")+" jugador:");
            System.out.println(Menu.SET_PLAYER_NAME.getText());
            p1 = Console.leer.readLine();
            System.out.println(textHighlighter.getFormattedString("Segundo")+" jugador:");
            System.out.println(Menu.SET_PLAYER_NAME.getText());
            p2 = Console.leer.readLine();
            controller.setUpPlayers(p1, p2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean play() {
        while (controller.getWinner() == null) {
            GamePlayer player = (turnCounter % 2 == 0) ? controller.getP1() : controller.getP2();
            selectTurnMenuOption(player);
            turnCounter++;
//            ToDo hacer play un template y optimizar este codigo
        }
        return true;
    }

    protected void displayTurnDefaulInformation(String playerName) {
        printTable();
        System.out.println("Es el turno de:\t" +
                textHighlighter.getFormattedString(playerName)+
                "\tTurno: "+numberHighlighter.getFormattedString(String.valueOf(turnCounter)));
        printTurnMenu();
    }

    public abstract void selectTurnMenuOption(GamePlayer player);

    protected abstract void printTurnMenu();

    public abstract void printTable();

}
