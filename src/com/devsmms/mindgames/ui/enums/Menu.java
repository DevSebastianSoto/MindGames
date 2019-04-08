package com.devsmms.mindgames.ui.enums;

public enum Menu {
    BASIC_TURN_OPTIONS("+-----------------+\n| 1. Elegir Pieza |\n| 2. Salir        |\n+-----------------+\nDigite el número que corresponde a su juego deseado."),
    SET_GAME_OPTIONS("+--------------+\n| 1. Checkers  |\n| 2. Chess     |\n| 3. Go        |\n+--------------+\nDigite el número que corresponde a su juego deseado.");

    private String text;

    Menu(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
