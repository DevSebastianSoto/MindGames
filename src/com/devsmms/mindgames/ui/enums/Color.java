package com.devsmms.mindgames.ui.enums;

public enum Color {
    BLACK(30),
    RED(31),
    GREEN(32),
    YELLOW(33),
    BLUE(34),
    MAGENTA(35),
    CYAN(36),
    WHITE(37),
    RESET(0);

    private final int value;

    Color(int value){
        this.value = value;
    }

    public int getBackGroundValue(){
        return value+10;
    }

    public int getTextValue() {
        return value;
    }
}
