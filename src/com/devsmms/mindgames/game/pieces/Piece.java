package com.devsmms.mindgames.game.pieces;

import com.devsmms.mindgames.game.enums.PieceColor;

public abstract class Piece {
    protected PieceColor color;
    protected String icon;

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }

    public String getIcon() {
        return icon;
    }
}
