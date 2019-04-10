package com.devsmms.mindgames.ui.console;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.pieces.Piece;
import com.devsmms.mindgames.game.players.GamePlayer;
import com.devsmms.mindgames.ui.enums.Color;
import com.devsmms.mindgames.ui.enums.Menu;
import com.devsmms.mindgames.ui.print.ColorPrinter;
import com.devsmms.mindgames.ui.print.MotionPieceTablePrinter;

import java.io.IOException;

public class ChessConsole extends GameConsole {

    private final ColorPrinter suggested;

    public ChessConsole(){
        super(GameTypes.CHESS,"Preparate para jugar Chess!");
        this.suggested = (new ColorPrinter.PrinterBuilder())
                .withBrightness(true)
                .withTextColor(Color.RED)
                .withBackGroundColor(Color.GREEN)
                .build();
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
        System.out.println("Jugador juega jugando chess");
    }

    @Override
    public void printTable() {
        MotionPieceTablePrinter.printTable(controller.getGameTable().getTable(),rowName,colName,numberHighlighter,black,white);
    }
}
