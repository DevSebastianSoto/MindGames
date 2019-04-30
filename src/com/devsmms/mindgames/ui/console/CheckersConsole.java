package com.devsmms.mindgames.ui.console;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.pieces.Piece;
import com.devsmms.mindgames.game.players.MotionPiecePlayer;
import com.devsmms.mindgames.game.tables.MotionPieceTable;

import java.io.IOException;
import java.util.ArrayList;

public class CheckersConsole extends MotionPieceConsole {

    public CheckersConsole() {
        super(GameTypes.CHECKERS, "Bienvenido a Checkers");
    }

    @Override
    protected void playTurn() throws IOException {
        boolean finished = false;
        while (!finished) {
            String pieceCoordinates = validCoordinateHelper();
            ArrayList<ArrayList<Integer>> suggestions = suggestedMoveHandler(pieceCoordinates);
            if (suggestions != null) {
                if (suggestions.size() > 0) {
                    printSuggestionsTable(suggestions);
                    boolean validSelection;
                    int[] coords;
                    do {
                        String selectedSuggestionCoordinates = validCoordinateHelper();
                        coords = textCoordinateParser(selectedSuggestionCoordinates);
                        validSelection = selectSuggestionValidator(coords, suggestions);
                    } while (!validSelection);
                    int[] prevCoords = textCoordinateParser(pieceCoordinates);

                    boolean pieceActionFinished;
                    do {
                        pieceActionFinished = ((MotionPiecePlayer) currentPlayer).handleMotion(controller.getGameTable().getTable(), prevCoords[0], prevCoords[1], coords[0], coords[1]);
                    } while (!pieceActionFinished);
                    finished = true;
                } else if (suggestions.size() == 0) {
                    System.out.println("No hay movimientos posibles para esta pieza en esta posicion.");
                }
            } else {
                System.out.println("Ese espacio no tiene ninguna pieza.");
            }
        }
    }
}
