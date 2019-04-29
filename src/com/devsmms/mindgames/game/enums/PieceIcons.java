package com.devsmms.mindgames.game.enums;

public enum PieceIcons {
    ROOK("\u2656"),KNIGHT("\u2658"),BISHOP("\u2657"),KING("\u2654"),QUEEN("\u2655"),PAWN("\u2659"),CHECKERS_NORMAL("\u26C0"),CHECKERS_KING("\u26C1"),GO("⏣");

    String icon;

    PieceIcons(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public String getTabbedIcon(){
        return '\t'+icon+'\t';
    }
}
