package com.devsmms;

import com.devsmms.mindgames.game.enums.PieceIcons;
import com.devsmms.mindgames.game.pieces.Piece;
import com.devsmms.mindgames.game.tables.GoTable;
import com.devsmms.mindgames.print.Color;
import com.devsmms.mindgames.print.ColorPrinter;

public class Main {

    public static void main(String[] args) {
        ColorPrinter p1printer = (new ColorPrinter.PrinterBuilder())
                .withBackGroundColor(Color.BLUE)
                .withBrightness(true)
                .withTextColor(Color.YELLOW)
                .build();
        ColorPrinter p2printer = (new ColorPrinter.PrinterBuilder())
                .withBackGroundColor(Color.BLUE)
                .withBrightness(true)
                .withTextColor(Color.MAGENTA)
                .build();

        String color1 = PieceIcons.BISHOP.getIcon() +
                PieceIcons.QUEEN.getIcon() +
                PieceIcons.GO.getIcon() +
                PieceIcons.CHECKERS_KING.getIcon() +
                PieceIcons.CHECKERS_NORMAL.getIcon();
        System.out.println(p1printer.getFormattedString(color1));
        System.out.println(p2printer.getFormattedString(color1));

        System.out.println(p1printer.getFormattedString("-" + PieceIcons.GO.getIcon() + "-"));
        System.out.println(p1printer.getFormattedString("-"+ GoTable.intersection +"-"));
        System.out.println(p1printer.getFormattedString("-+-"));
    }
}
