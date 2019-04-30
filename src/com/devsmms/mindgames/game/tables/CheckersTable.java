package com.devsmms.mindgames.game.tables;

import java.util.ArrayList;

import com.devsmms.mindgames.game.enums.PieceColor;
import com.devsmms.mindgames.game.pieces.CheckersPiece;
import com.devsmms.mindgames.game.pieces.Piece;
import com.devsmms.mindgames.ui.enums.Color;

public class CheckersTable extends GameTable implements MotionPieceTable {

    public CheckersTable() {
        this.table = new Piece[10][10];
        initTableWithPieces();
    }

    private ArrayList<ArrayList<Integer>> filterMoves(CheckersPiece p, MoveDirection dir) {
        int[][] moves = p.calcMove();
        ArrayList<ArrayList<Integer>> moveList = new ArrayList<>();
        switch (dir) {
            case ALL:
                for(int i =0;i<moves.length;i++){
                    ArrayList<Integer> coordinates = new ArrayList<>();
                    coordinates.add(moves[i][0]);
                    coordinates.add(moves[i][1]);
                    moveList.add(coordinates);
                }
                break;
            case BOTTOMTOP:
                for(int i =0;i<moves.length;i++){
                    ArrayList<Integer> coordinates = new ArrayList<>();
                    if(moves[i][0] > 0){
                        coordinates.add(moves[i][0]);
                        coordinates.add(moves[i][1]);
                        moveList.add(coordinates);
                    }
                }
                break;
            case TOPBOTTOM:
                for(int i =0;i<moves.length;i++){
                    ArrayList<Integer> coordinates = new ArrayList<>();
                    if(moves[i][0] < 0){
                        coordinates.add(moves[i][0]);
                        coordinates.add(moves[i][1]);
                        moveList.add(coordinates);
                    }
                }
                break;
        }
        return moveList;
    }

    public ArrayList<ArrayList<Integer>> suggestAllMoves(int x, int y, MoveDirection dir) {
        if (this.table[y][x] != null) {
            CheckersPiece p = (CheckersPiece) this.table[y][x];
            if (p != null) {
                ArrayList<ArrayList<Integer>> moves = filterMoves(p, dir);
                ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

                for (int i = 0; i < moves.size(); i++) {
                    ArrayList<Integer> coords = moves.get(i);
                    int yCoords = y + coords.get(0);
                    int xCoords = x + coords.get(1);
                    if ((yCoords >= 0 && yCoords < this.table.length) && (xCoords >= 0 && xCoords < this.table.length)) {
                        CheckersPiece pieceInCoords = (CheckersPiece) this.table[yCoords][xCoords];
                        ArrayList<Integer> pos = new ArrayList<>();

                        if (pieceInCoords == null || pieceInCoords.getColor() != p.getColor()) {
                            pos.add(xCoords);
                            pos.add(yCoords);
                            matrix.add(pos);
                        }
                    }
                }
                return matrix;
            }
        }
        return null;
    }

    @Override
    public ArrayList<ArrayList<Integer>> suggestMove(int x, int y) {
        ArrayList<ArrayList<Integer>> allMoves = suggestAllMoves(x, y, MoveDirection.ALL);
        for (ArrayList<Integer> pos : allMoves) {
            int xPos = pos.get(0);
            int yPos = pos.get(1);

            if ((this.table[yPos][xPos]) != null && (this.table[yPos][xPos]).getColor() != (this.table[y][x]).getColor()) {
                System.out.println("Hola buenas! soy enemigo");
            }
        }

        CheckersPiece p = (CheckersPiece) this.table[y][x];

        if (p.getColor() == PieceColor.WHITE) {
            return suggestAllMoves(x,y,MoveDirection.BOTTOMTOP);
        } else {
            return suggestAllMoves(x,y,MoveDirection.TOPBOTTOM);
        }

    }

    @Override
    public void initTableWithPieces() {
        int firstLevel = 0;
        int secondLevel = 1;
        for (int i = 0; i < 5; i++) {
            Piece checkerPiece1 = new CheckersPiece();
            Piece checkerPiece2 = new CheckersPiece();
            Piece checkerPiece3 = new CheckersPiece();
            Piece checkerPiece4 = new CheckersPiece();

            checkerPiece1.setColor(PieceColor.BLACK);
            checkerPiece2.setColor(PieceColor.BLACK);
            checkerPiece3.setColor(PieceColor.BLACK);
            checkerPiece4.setColor(PieceColor.BLACK);

            this.table[9][firstLevel] = checkerPiece1;
            this.table[7][firstLevel] = checkerPiece2;

            this.table[8][secondLevel] = checkerPiece3;
            this.table[6][secondLevel] = checkerPiece4;

            Piece checkerPiece5 = new CheckersPiece();
            Piece checkerPiece6 = new CheckersPiece();
            Piece checkerPiece7 = new CheckersPiece();
            Piece checkerPiece8 = new CheckersPiece();

            checkerPiece5.setColor(PieceColor.WHITE);
            checkerPiece6.setColor(PieceColor.WHITE);
            checkerPiece7.setColor(PieceColor.WHITE);
            checkerPiece8.setColor(PieceColor.WHITE);

            this.table[1][firstLevel] = checkerPiece5;
            this.table[3][firstLevel] = checkerPiece6;

            this.table[0][secondLevel] = checkerPiece7;
            this.table[2][secondLevel] = checkerPiece8;

            firstLevel += 2;
            secondLevel += 2;
        }
    }

    private enum MoveDirection {
        ALL, BOTTOMTOP, TOPBOTTOM;
    }
}