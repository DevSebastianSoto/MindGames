package com.devsmms.mindgames.print.console;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.print.factory.ConsoleFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
    private static Console console = null;
    private static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    private GameConsole gc;

    private Console() {
        gc = null;
    }

    public static Console getInstance() {
        if (console == null)
            console = new Console();
        return console;
    }

    public void start() {
        printGreetings();
        setGameConsole();
        gc.printMainMenu();
    }

    public void setGameConsole() {
        GameTypes type;
        if (gc == null)
            type = selectGame();
        else
            type = gc.selectGame();
        gc = ConsoleFactory.getConsole(type);
    }

    private void printGreetings(){
        System.out.println("Bienvenido a Mind Games, el mejor centro virtual de juegos de mesa.");
    }

    private void printGameSelectionMenu() {
        String menu = "";
        menu += "+--------------+\n";
        menu += "| 1. Checkers  |\n";
        menu += "| 2. Chess     |\n";
        menu += "| 3. Go        |\n";
        menu += "+--------------+\n";
        menu += "Digite el número que corresponde a su juego deseado.";
        System.out.println(menu);
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

}
