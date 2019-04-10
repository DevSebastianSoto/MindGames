package com.devsmms.mindgames.game.pieces;

import com.devsmms.mindgames.game.enums.PieceColor;
import com.devsmms.mindgames.game.enums.PieceIcons;

public abstract class Piece {
    protected PieceColor color;
    protected PieceIcons icon;

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }

    public PieceIcons getIcon() {
        return icon;
    }
}
