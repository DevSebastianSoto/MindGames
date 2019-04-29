package com.devsmms.mindgames.ui.console;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.pieces.Piece;
import com.devsmms.mindgames.game.tables.MotionPieceTable;

import java.util.ArrayList;

public class CheckersConsole extends MotionPieceConsole {

    public CheckersConsole() {
        super(GameTypes.CHECKERS, "Bienvenido a Checkers");
    }


    @Override
    public void handleMotion(int prevX, int prevY, int postX, int postY) {
        Piece[][] table = controller.getGameTable().getTable();

        Piece p = table[prevY][prevX];
        table[postY][postX] = p;
        table[prevY][prevX] = null;

    }


    public void movePiece(){

    }
}
