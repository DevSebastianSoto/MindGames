package com.devsmms.mindgames.ui.console;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.players.GamePlayer;
import com.devsmms.mindgames.game.tables.ChessTable;
import com.devsmms.mindgames.game.tables.MotionPieceTable;
import com.devsmms.mindgames.ui.enums.Color;
import com.devsmms.mindgames.ui.enums.Menu;
import com.devsmms.mindgames.ui.print.ColorPrinter;
import com.devsmms.mindgames.ui.print.TablePrinter;

import java.io.IOException;
import java.util.ArrayList;

public class MotionPieceConsole extends GameConsole {

    private final ColorPrinter suggested;

    MotionPieceConsole(GameTypes type, String greeting) {
        super(type, greeting);
        this.suggested = (new ColorPrinter.PrinterBuilder())
                .withBrightness(true)
                .withTextColor(Color.RED)
                .withBackGroundColor(Color.GREEN)
                .build();
    }

    @Override
    public boolean selectTurnMenuOption(GamePlayer player) {
        try {
            playTurn();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void playTurn() throws IOException {
        boolean validCoords;
        String textCoords;
        do {
            textCoords = Console.leer.readLine();
            validCoords = selectPiece(textCoords);
        }while(!validCoords);
        printTable(suggestedMoveHandler(textCoords));
    }

    public ArrayList<ArrayList<Integer>> suggestedMoveHandler(String textCoords){
        textCoords = textCoords.toUpperCase();
        char col = textCoords.charAt(0);
        int row = Integer.parseInt(textCoords.charAt(1)+"");
        MotionPieceTable motionPieceTable = (MotionPieceTable) controller.getGameTable();
        int [] coords = controller.getGameTable().translateCoords(col,row);
        return motionPieceTable.suggestMove(coords[0],coords[1]);
    }

    public boolean selectPiece(String textCoords) {
        if (controller.coordinatesValidation(textCoords)) {
            return true;
        } else {
            System.out.println("Esas coordenadas no existen o no estan en el formato indicado. Intenta de nuevo.");
            return false;
        }
    }

    @Override
    protected void printTurnMenu() {
        System.out.println(Menu.SELECT_PIECE.getText());
    }

    @Override
    public void printTable() {
        TablePrinter.printTable(controller.getGameTable().getTable(), numberHighlighter, null);
    }

    public void printTable(ArrayList<ArrayList<Integer>> suggestions) {
        TablePrinter.printTable(controller.getGameTable().getTable(), numberHighlighter, suggestions);
    }
}
