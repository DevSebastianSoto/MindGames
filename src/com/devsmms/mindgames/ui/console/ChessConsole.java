package com.devsmms.mindgames.ui.console;

import com.devsmms.mindgames.game.enums.GameTypes;

public class ChessConsole extends MotionPieceConsole {

    public ChessConsole() {
        super(GameTypes.CHESS, "Preparate para jugar Chess!");
    }

    @Override
    public void handleMotion(int prevX, int prevY, int postX, int postY) {

    }
}
