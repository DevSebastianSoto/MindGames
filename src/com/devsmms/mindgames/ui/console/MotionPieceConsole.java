package com.devsmms.mindgames.ui.console;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.pieces.Piece;
import com.devsmms.mindgames.game.players.GamePlayer;
import com.devsmms.mindgames.game.players.MotionPiecePlayer;
import com.devsmms.mindgames.game.tables.ChessTable;
import com.devsmms.mindgames.game.tables.GameTable;
import com.devsmms.mindgames.game.tables.MotionPieceTable;
import com.devsmms.mindgames.ui.enums.Color;
import com.devsmms.mindgames.ui.enums.Menu;
import com.devsmms.mindgames.ui.print.ColorPrinter;
import com.devsmms.mindgames.ui.print.TablePrinter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class MotionPieceConsole extends GameConsole {

    MotionPieceConsole(GameTypes type, String greeting) {
        super(type, greeting);
    }

    @Override
    public boolean selectTurnMenuOption(GamePlayer player) {
        try {
            this.currentPlayer = player;
            playTurn();

            if(ChessTable.class.getName() == controller.getGameTable().getClass().getName()){
                if( ((ChessTable)controller.getGameTable()).getBlackKing().isAlive() == false || ((ChessTable)controller.getGameTable()).getWhiteKing().isAlive() == false ){
                    System.out.println("El rey ha muerto! El juego ha acabado! El ganador es: " + this.currentPlayer.getName());
                    controller.setWinner(this.currentPlayer);
                }
            }

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    protected void playTurn() throws IOException {
        boolean finished = false;
        while (!finished) {
            String selectedPieceCoordinates = validCoordinateHelper();
            ArrayList<ArrayList<Integer>> suggestions = suggestedMoveHandler(selectedPieceCoordinates);
            if (suggestions != null) {
                if (suggestions.size() > 0) {
                    printSuggestionsTable(suggestions);
                    int[] prevCoords = textCoordinateParser(selectedPieceCoordinates);
                    int[] postCoords = selectSuggestion(suggestions);
                    movePieceByCurrentPlayer(prevCoords,postCoords);
                    finished = true;
                }else{
                    System.out.println(Menu.NO_SUGGESTIONS.getText());
                }
            }else{
                System.out.println(Menu.NO_PIECE_IN_CELL.getText());
            }
        }
    }

    private void movePieceByCurrentPlayer(int[] prevCoords, int[] postCoords){
        ((MotionPiecePlayer)this.currentPlayer).handleMotion(this.controller.getGameTable(),prevCoords[0],prevCoords[1],postCoords[0],postCoords[1]);
    }

    protected int [] selectSuggestion(ArrayList<ArrayList<Integer>> suggestions) throws IOException {
        boolean validSelection;
        int[] coords;
        do {
            String selectedSuggestionCoordinates = validCoordinateHelper();
            coords = textCoordinateParser(selectedSuggestionCoordinates);
            validSelection = selectSuggestionValidator(coords, suggestions);
        } while (!validSelection);
        return coords;
    }

    protected boolean selectSuggestionValidator(int[] coords, ArrayList<ArrayList<Integer>> suggestions) {
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

    protected ArrayList<ArrayList<Integer>> suggestedMoveHandler(String textCoordinates) {
        int[] coords = textCoordinateParser(textCoordinates);
        int x = coords[0];
        int y = coords[1];
        MotionPieceTable motionPieceTable = (MotionPieceTable) controller.getGameTable();
        return motionPieceTable.suggestMove(x, y);
    }

    protected int[] textCoordinateParser(String textCoordinates) {
        textCoordinates = textCoordinates.toUpperCase();
        char col = textCoordinates.charAt(0);
        int row = Integer.parseInt(textCoordinates.charAt(1) + "");
        return controller.getGameTable().translateCoords(col, row);
    }

    protected String validCoordinateHelper() throws IOException {
        boolean validCoords;
        String textCoords;
        do {
            textCoords = Console.leer.readLine();
            validCoords = selectCoords(textCoords);
        } while (!validCoords);
        return textCoords;
    }

    protected boolean selectCoords(String textCoords) {
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

    protected void printSuggestionSelectionInstructions() {
        System.out.println(Menu.SELECT_SUGGESTION.getText());
    }

    @Override
    public void printTable() {
        TablePrinter.printTable(controller.getGameTable().getTable(), numberHighlighter, null);
    }

    public void printSuggestionsTable(ArrayList<ArrayList<Integer>> suggestions) {
        TablePrinter.printTable(controller.getGameTable().getTable(), numberHighlighter, suggestions);
        printSuggestionSelectionInstructions();
    }

}
