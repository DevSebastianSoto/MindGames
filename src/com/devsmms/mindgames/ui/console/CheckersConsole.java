package com.devsmms.mindgames.ui.console;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.enums.PieceColor;
import com.devsmms.mindgames.game.pieces.Piece;
import com.devsmms.mindgames.game.players.GamePlayer;
import com.devsmms.mindgames.ui.enums.Color;
import com.devsmms.mindgames.ui.enums.Menu;
import com.devsmms.mindgames.ui.print.ColorPrinter;

import java.io.IOException;

public class CheckersConsole extends GameConsole {

    private final ColorPrinter suggested;
    private final Color bgBlack;
    private final Color bgWhite;

    public CheckersConsole() {
        super(GameTypes.CHECKERS, "Bienvenido a Checkers");
        this.suggested = (new ColorPrinter.PrinterBuilder())
                .withBrightness(true)
                .withTextColor(Color.RED)
                .withBackGroundColor(Color.GREEN)
                .build();
        this.bgBlack = Color.BLACK;
        this.bgWhite = Color.WHITE;
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

    }

    @Override
    public void printTable() {
        Piece[][] tableMap = controller.getGameTable().getTable();
        String tableView = "";
        for (int i = 0; i < tableMap.length; i++) {
            tableView += this.numberHighlighter.getFormattedString(rowName[i] + "\t");
            for (int j = 0; j < tableMap[i].length; j++) {
                Color bg = (i % 2 == 0) ?
                        (j % 2 == 0) ?
                                this.bgWhite :
                                this.bgBlack :
                        (j % 2 == 0) ?
                                this.bgBlack :
                                this.bgWhite;
                ColorPrinter.PrinterBuilder pb = (new ColorPrinter.PrinterBuilder())
                        .withBackGroundColor(bg)
                        .withBrightness(true);
                if (tableMap[i][j] != null) {
                    Color text = (tableMap[i][j].getColor() == PieceColor.BLACK) ?
                            this.black :
                            this.white;

                    tableView += (pb.withTextColor(text).build()).
                            getFormattedString(tableMap[i][j].getIcon().getTabbedIcon());
                } else {
                    tableView += (pb.build()).getFormattedString("\t_\t");
                }
            }
            tableView += "\n";
        }
        tableView += "\t";
        String line = "  ";
        for (int i = 0; i < colName.length; i++) {
            tableView += this.textHighlighter.getFormattedString(colName[i] + "\t");
            line += "-___";
        }
        tableView += "\n" + line + "-\n";
        System.out.println(tableView);
    }

}
