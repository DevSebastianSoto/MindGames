package com.devsmms.mindgames.ui.print;

import com.devsmms.mindgames.game.enums.PieceColor;
import com.devsmms.mindgames.game.pieces.Piece;
import com.devsmms.mindgames.ui.console.GameConsole;
import com.devsmms.mindgames.ui.enums.Color;

import java.util.ArrayList;

public class TablePrinter {

    public static void initRowNumbers(int [] rowName) {
        for (int i = rowName.length - 1; i >= 0; i--) {
            rowName[(i - (rowName.length - 1)) * -1] = i + 1;
        }
    }

    public static void initColNames(char [] colName) {
        int unicode = 0x41;
        for (int i = 0; i < colName.length; i++) {
            colName[i] = (char) (unicode + i);
        }
    }
    public static void printTable(Piece[][] tableMap, ColorPrinter highlighter, ArrayList<ArrayList<Integer>> suggestions){
        int dim = tableMap.length;
        int [] rowName = new int[dim];
        char [] colName = new char[dim];

        initRowNumbers(rowName);
        initColNames(colName);

        Color black = Color.BLUE;
        Color white = Color.RED;
        String tableView = "";
        for (int i = 0; i < tableMap.length; i++) {
            tableView += highlighter.getFormattedString(rowName[i] + "\t");
            for (int j = 0; j < tableMap[i].length; j++) {
//                Sets the cell bg color
                Color bg = paintBackground(i, j, suggestions);
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
        for (int i = 0; i < colName.length; i++) {
            tableView += highlighter.getFormattedString("\t" + colName[i] + "\t");
        }
        System.out.println(tableView);
    }

    private static Color paintBackground(int i, int j, ArrayList<ArrayList<Integer>> suggestions) {
        Color bg = (i % 2 == 0) ?
                (j % 2 == 0) ?
                        Color.WHITE :
                        Color.BLACK :
                (j % 2 == 0) ?
                        Color.BLACK :
                        Color.WHITE;

        if (suggestions != null) {
            for (ArrayList<Integer> coords : suggestions) {
                if (coords.get(0) == j && coords.get(1) == i) {
                    bg = Color.GREEN;
                }
            }
        }
        return bg;
    }
}
