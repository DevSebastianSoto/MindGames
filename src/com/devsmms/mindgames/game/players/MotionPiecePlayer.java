package com.devsmms.mindgames.game.players;

import com.devsmms.mindgames.game.tables.GameTable;

public interface MotionPiecePlayer {

    void handleMotion(GameTable gTable, int prevX, int prevY, int postX, int postY);

}
