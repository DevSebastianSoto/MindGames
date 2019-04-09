package com.devsmms.mindgames.ui.console;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.ui.enums.Menu;
import com.devsmms.mindgames.ui.factory.ConsoleFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
    private static Console console = null;
    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    private GameConsole gc;

    private Console() {
        gc = null;
    }

    public void start() {
        printGreetings();
        setGameConsole();
        gc.selectMainMenuOption();
    }

    private void setGameConsole() {
        GameTypes type = selectGame();
        gc = ConsoleFactory.getConsole(type);
    }

    private void printGreetings(){
        System.out.println("Bienvenido a Mind Games, el mejor centro virtual de juegos de mesa.");
    }

    private void printGameSelectionMenu() {
        System.out.println(Menu.SET_GAME_OPTIONS.getText());
    }

    private GameTypes selectGame() {
        GameTypes type = null;
        while (type == null) {
            printGameSelectionMenu();
            try {
                int opcion = Integer.parseInt(leer.readLine());
                switch (opcion) {
                    case 1:
                        type = GameTypes.CHECKERS;
                        break;
                    case 2:
                        type = GameTypes.CHESS;
                        break;
                    case 3:
                        type = GameTypes.GO;
                        break;
                    default:
                        System.out.println("Esa opcion no es valida");
                        type = null;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor digite un numero");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return type;
    }

    public static Console getInstance() {
        if (console == null)
            console = new Console();
        return console;
    }

}
