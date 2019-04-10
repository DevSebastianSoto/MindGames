package com.devsmms.mindgames.ui.console;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.enums.PieceColor;
import com.devsmms.mindgames.game.pieces.Piece;
import com.devsmms.mindgames.game.players.GamePlayer;
import com.devsmms.mindgames.game.tables.GoTable;
import com.devsmms.mindgames.ui.enums.Color;
import com.devsmms.mindgames.ui.enums.Menu;
import com.devsmms.mindgames.ui.print.ColorPrinter;

import java.io.IOException;

public class GoConsole extends GameConsole {

    private final Color bg;

    public GoConsole() {
        super(GameTypes.GO, "Preparate para jugar GO!");
        bg = Color.BLACK;
    }

    @Override
    public void selectTurnMenuOption(GamePlayer player) {
        displayTurnDefaulInformation(player.getName());
        try {
            Console.leer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void printTurnMenu() {
        System.out.println("Jugador juega jugando checkers");
    }

    @Override
    public void printTable() {
        String tableView = "";
        Piece [][] tableMap = controller.getGameTable().getTable();
        ColorPrinter.PrinterBuilder pb = (new ColorPrinter.PrinterBuilder())
                .withBrightness(true);
        for (int i = 0; i < tableMap.length; i++) {
            tableView += textHighlighter.getFormattedString(rowName[i] + "\t");
            for (int j = 0; j < tableMap[i].length; j++) {
                if (tableMap[i][j] != null) {
                    Color text = (tableMap[i][j].getColor() == PieceColor.BLACK) ?
                            black :
                            white;
                    tableView += (pb.withTextColor(text).build()).
                            getFormattedString(tableMap[i][j].getIcon().getIcon()+"\t");
                } else {
                    tableView += (pb.withTextColor(bg).build()).getFormattedString(GoTable.intersection+"\t");
                }
            }
            tableView += "\n";
        }
        tableView += "\t";
        String line = "  ";
        for (int i = 0; i < colName.length; i++) {
            tableView += textHighlighter.getFormattedString(colName[i] + "\t");
        }
        System.out.println(tableView);
    }
}
