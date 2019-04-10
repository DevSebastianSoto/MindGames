package com.devsmms.mindgames.ui.print;

import com.devsmms.mindgames.game.enums.PieceColor;
import com.devsmms.mindgames.game.pieces.Piece;
import com.devsmms.mindgames.ui.console.GameConsole;
import com.devsmms.mindgames.ui.enums.Color;

public class MotionPieceTablePrinter {

    private static final Color bgWhite = Color.WHITE;
    private static final Color bgBlack = Color.BLACK;

    public static void printTable(Piece [][] tableMap,int [] rowName, char [] colName,ColorPrinter highlighter,Color black, Color white){
        String tableView = "";
        for (int i = 0; i < tableMap.length; i++) {
            tableView += highlighter.getFormattedString(rowName[i] + "\t");
            for (int j = 0; j < tableMap[i].length; j++) {
                Color bg = (i % 2 == 0) ?
                        (j % 2 == 0) ?
                                bgWhite :
                                bgBlack :
                        (j % 2 == 0) ?
                                bgBlack :
                                bgWhite;
                ColorPrinter.PrinterBuilder pb = (new ColorPrinter.PrinterBuilder())
                        .withBackGroundColor(bg)
                        .withBrightness(true);
                if (tableMap[i][j] != null) {
                    Color text = (tableMap[i][j].getColor() == PieceColor.BLACK) ?
                            black :
                            white;

                    tableView += (pb.withTextColor(text).build()).
                            getFormattedString(tableMap[i][j].getIcon().getTabbedIcon());
                } else {
                    tableView += (pb.build()).getFormattedString("\t\t");
                }
            }
            tableView += "\n";
        }
        tableView += "\t";
        String line = "  ";
        for (int i = 0; i < colName.length; i++) {
            tableView += highlighter.getFormattedString("\t"+colName[i] + "\t");
        }
        System.out.println(tableView);
    }
}
