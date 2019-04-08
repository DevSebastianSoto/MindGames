package com.devsmms.mindgames.ui.enums;

public enum Color {
    BLUE(34),
    CYAN(36),
    RED(31),
    YELLOW(33),
    MAGENTA(35),
    GREEN(32),
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
