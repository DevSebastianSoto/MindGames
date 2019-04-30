package com.devsmms.mindgames.game.players;

import com.devsmms.mindgames.game.pieces.Piece;

public interface MotionPiecePlayer {
    boolean handleMotion(Piece[][] table, int prevX, int prevY, int postX, int postY);
}
