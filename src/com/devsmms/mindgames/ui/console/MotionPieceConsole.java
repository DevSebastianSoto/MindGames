package com.devsmms.mindgames.ui.console;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.pieces.Piece;
import com.devsmms.mindgames.game.players.GamePlayer;
import com.devsmms.mindgames.game.tables.ChessTable;
import com.devsmms.mindgames.game.tables.GameTable;
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

    private boolean playTurn() throws IOException {
        boolean finished = false;
        while(!finished){
            String pieceCoordinates = validCoordinateHelper();
            ArrayList<ArrayList<Integer>> suggestions = suggestedMoveHandler(pieceCoordinates);
            if (suggestions != null) {
                if (suggestions.size() > 0) {
                    printTable(suggestions);
                    printSuggestionSelectionInstructions();
                    boolean validSelection;
                    do {
                        String selectedSuggestionCoordinates = validCoordinateHelper();
                        int[] coords = textCoordinateParser(selectedSuggestionCoordinates);
                        validSelection = selectSuggestion(coords, suggestions);
                    } while (!validSelection);
//            TODO hacer metodo que reciba "pieceCoordinates" y "selectedSuggestionCoordinates" para que el Player mueva la pieza
                    System.out.println("Se cambia la pieza de lugar y se maneja el turno extra");
                    finished = true;
                } else if (suggestions.size() == 0) {
                    System.out.println("No hay movimientos posibles para esta pieza en esta posicion.");
                }
            } else {
                System.out.println("Ese espacio no tiene ninguna pieza.");
            }
        }
        return true;
    }

    private boolean selectSuggestion(int[] coords, ArrayList<ArrayList<Integer>> suggestions) {
        boolean valid = false;
        for (ArrayList<Integer> pos : suggestions) {
            if (pos.get(0) == coords[0] && pos.get(1) == coords[1]) {
                valid = true;
            }
        }
        if (!valid) {
            System.out.println("Las coordenadas digitadas no son un movimiento sugerido.");
        }
        return valid;

    }

    private ArrayList<ArrayList<Integer>> suggestedMoveHandler(String textCoordinates) {
        int[] coords = textCoordinateParser(textCoordinates);
        int x = coords[0];
        int y = coords[1];
        MotionPieceTable motionPieceTable = (MotionPieceTable) controller.getGameTable();
        return motionPieceTable.suggestMove(x, y);
    }

    private int[] textCoordinateParser(String textCoordinates) {
        textCoordinates = textCoordinates.toUpperCase();
        char col = textCoordinates.charAt(0);
        int row = Integer.parseInt(textCoordinates.charAt(1) + "");
        return controller.getGameTable().translateCoords(col, row);
    }

    private String validCoordinateHelper() throws IOException {
        boolean validCoords;
        String textCoords;
        do {
            textCoords = Console.leer.readLine();
            validCoords = selectCoords(textCoords);
        } while (!validCoords);
        return textCoords;
    }

    private boolean selectCoords(String textCoords) {
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

    private void printSuggestionSelectionInstructions() {
        System.out.println(Menu.SELECT_SUGGESTION.getText());
    }

    @Override
    public void printTable() {
        TablePrinter.printTable(controller.getGameTable().getTable(), numberHighlighter, null);
    }

    public void printTable(ArrayList<ArrayList<Integer>> suggestions) {
        TablePrinter.printTable(controller.getGameTable().getTable(), numberHighlighter, suggestions);
    }
}
