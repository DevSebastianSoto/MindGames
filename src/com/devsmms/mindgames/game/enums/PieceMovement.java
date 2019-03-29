package com.devsmms.mindgames.game.enums;

public enum PieceMovement {
    TOP(0,-1),BOTTOM(0,1),LEFT(-1,0),RIGHT(1,0),
    TOPLEFT(-1,-1),BOTTOMLEFT(-1,1),TOPRIGHT(1,-1),BOTTOMRIGHT(1,1),
    LEFTTOP(-1,-1),RIGHTTOP(1,-1),LEFTBOTTOM(-1,1 ),RIGHTBOTTOM(1,1);

    private int x;
    private int y;

    PieceMovement(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
