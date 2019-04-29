package com.devsmms.mindgames.ui.console;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.pieces.Piece;
import com.devsmms.mindgames.game.tables.MotionPieceTable;

import java.util.ArrayList;

public class CheckersConsole extends MotionPieceConsole {

    public CheckersConsole() {
        super(GameTypes.CHECKERS, "Bienvenido a Checkers");
    }

}
