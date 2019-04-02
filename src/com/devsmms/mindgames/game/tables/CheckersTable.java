package com.devsmms.mindgames.game.tables;

import com.devsmms.mindgames.game.enums.PieceColor;
import com.devsmms.mindgames.game.pieces.CheckersPiece;
import com.devsmms.mindgames.game.pieces.Piece;

public class CheckersTable extends GameTable implements MotionPieceTable {

	public CheckersTable() {
		this.table = new Piece[10][10];
	}

	@Override
	public void suggestMove() {
		// TODO Auto-generated method stub

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
}
