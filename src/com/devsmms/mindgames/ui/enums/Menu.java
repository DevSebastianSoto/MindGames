package com.devsmms.mindgames.ui.enums;

public enum Menu {
    START_GAME_OPTIONS(
            "+--------------------+\n" +
                    "| 1. Empezar juego   |\n" +
                    "| 2. Salir al menu   |\n" +
                    "|    principal       |\n" +
                    "+--------------------+\n" +
                    "Digite el número que corresponde a su accion deseada."
    ),
    SET_GAME_OPTIONS(
            "+--------------+\n" +
                    "| 1. Checkers  |\n" +
                    "| 2. Chess     |\n" +
                    "| 3. Go        |\n" +
                    "+--------------+\n" +
                    "Digite el número que corresponde a su juego deseado."
    ),
    SET_PLAYER_NAME(
            "Por favor digite su nombre."
    ),
    SELECT_PIECE("Por favor, digite las cordenadas de la pieza que desea usar ejemplo \"a8\"."),
    SELECT_SUGGESTION("Por favor, digite las cordenadas de la sugerencia que desea jugar."),
    NO_SUGGESTIONS("No hay movimientos posibles para esta pieza en esta posicion."),
    NO_PIECE_IN_CELL("Ese espacio no tiene ninguna pieza.");

    private String text;

    Menu(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
