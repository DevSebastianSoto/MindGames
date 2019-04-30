package com.devsmms.mindgames.game.tables;

import java.util.ArrayList;

import com.devsmms.mindgames.game.enums.PieceColor;
import com.devsmms.mindgames.game.pieces.Piece;
import com.devsmms.mindgames.game.pieces.chess.Bishop;
import com.devsmms.mindgames.game.pieces.chess.King;
import com.devsmms.mindgames.game.pieces.chess.Knight;
import com.devsmms.mindgames.game.pieces.chess.Pawn;
import com.devsmms.mindgames.game.pieces.chess.Queen;
import com.devsmms.mindgames.game.pieces.chess.Rook;

public class ChessTable extends GameTable implements MotionPieceTable {
	ArrayList<ArrayList<Integer>> suggestions;

	public ChessTable() {
		this.table = new Piece[8][8];
		this.suggestions = new ArrayList<ArrayList<Integer>> ();
		initTableWithPieces();
	}

	@Override
	public ArrayList<ArrayList<Integer>> suggestMove(int x, int y) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

		if(isPiece(x,y) == false){
			return matrix;
		}else{
			switch (getTablePiece(x, y).getIcon()) {

				case PAWN:
					this.suggestions = pawnSuggestions(x, y);
					return suggestions;

				case KNIGHT:
					this.suggestions = knightSuggestions(x, y);
					return suggestions;

				case KING:
					this.suggestions = kingSuggestions(x,y);
					return suggestions;

				case QUEEN:
					this.suggestions = queenSuggestions(x,y);
					return suggestions;

				case ROOK:
					this.suggestions = rookSuggestions(x,y);
					return suggestions;

				case BISHOP:
					this.suggestions = bishopSuggestions(x,y);
					return suggestions;

				default:
					return matrix;
			}
		}
	}

	public void movePiece(int prex, int prey, int postx, int posty){
		if(validMove(postx,posty)){
			this.table[posty][postx] = this.table[prey][prex];
			this.table[prey][prex] = null;
		}else{
			System.out.println("Movimiento no valido");
		}
	}

	public boolean validMove(int x, int y){
		for(int i = 0; i < suggestions.size(); i++){
			if(suggestions.get(i).get(0) == x && suggestions.get(i).get(1) == y){
				return true;
			}
		}
		return false;
	}

	public boolean isPiece(int x, int y) {
		if (this.table[y][x] != null) {
			return true;
		} else {
			return false;
		}
	}

	public Piece getTablePiece(int x, int y) {
		return this.table[y][x];
	}

	public boolean rangeOfTable(int[] pos, int x, int y) {
		if(x + pos[0] < 8 && x + pos[0] >= 0){
			if(y + pos[1] < 8 && y + pos[1] >= 0){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	public int determineIndexForRookAndBishop(int i) {
		if (i >= 0 && i <= 6) {
			return 7;
		} else {
			if (i >= 7 && i <= 13) {
				return 14;
			} else {
				if (i >= 14 && i <= 20) {
					return 21;
				} else {
					if (i >= 21 && i <= 27) {
						return -1;
					} else {
						return -1;
					}
				}
			}
		}
	}

	public int determineIndexForQueen(int i) {
		if (i >= 0 && i <= 6) {
			return 7;
		} else {
			if (i >= 7 && i <= 13) {
				return 14;
			} else {
				if (i >= 14 && i <= 20) {
					return 21;
				} else {
					if (i >= 21 && i <= 27) {
						return 28;
					} else {
						if (i >= 28 && i <= 34) {
							return 35;
						} else {
							if (i >= 35 && i <= 41) {
								return 42;
							} else {
								if (i >= 42 && i <= 48) {
									return 49;
								} else {
									if (i >= 49 && i <= 55) {
										return -1;
									} else {
										return -1;
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public ArrayList<ArrayList<Integer>> knightSuggestions(int x, int y) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		int[][] moves = ((Knight)getTablePiece(x,y)).calcMove();
		for(int i = 0; i < moves.length; i++){
			if(knightMoves(moves[i],x,y)){
				ArrayList<Integer> pos = new ArrayList<Integer>();
				pos.add(x + moves[i][0]);
				pos.add(y + moves[i][1]);
				matrix.add(pos);
			}
		}
		return matrix;
	}

	public ArrayList<ArrayList<Integer>> rookSuggestions(int x, int y) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		int[][] moves = ((Rook)getTablePiece(x,y)).calcMove();
		for(int i = 0; i < moves.length; i++){
			if(rookBishopQueenMoves(moves[i],x,y) == 1){
				ArrayList<Integer> pos = new ArrayList<Integer>();
				pos.add(x + moves[i][0]);
				pos.add(y + moves[i][1]);
				matrix.add(pos);
			}else{
				if(rookBishopQueenMoves(moves[i],x,y) == -1){
					i = determineIndexForRookAndBishop(i);
				}

			}
		}
		return matrix;
	}

	public ArrayList<ArrayList<Integer>> bishopSuggestions(int x, int y) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		int[][] moves = ((Bishop)getTablePiece(x,y)).calcMove();
		for(int i = 0; i < moves.length; i++){
			if(rookBishopQueenMoves(moves[i],x,y) == 1){
				ArrayList<Integer> pos = new ArrayList<Integer>();
				pos.add(x + moves[i][0]);
				pos.add(y + moves[i][1]);
				matrix.add(pos);
			}else{
				if(rookBishopQueenMoves(moves[i],x,y) == -1){
					i = determineIndexForRookAndBishop(i);
				}

			}
		}
		return matrix;
	}

	public ArrayList<ArrayList<Integer>> kingSuggestions(int x, int y) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		int[][] moves = ((King)getTablePiece(x,y)).calcMove();
		for(int i = 0; i < moves.length; i++){
			if(kingMoves(moves[i],x,y)){
				ArrayList<Integer> pos = new ArrayList<Integer>();
				pos.add(x + moves[i][0]);
				pos.add(y + moves[i][1]);
				matrix.add(pos);
			}
		}
		return matrix;
	}

	public ArrayList<ArrayList<Integer>> queenSuggestions(int x, int y) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		int[][] moves = ((Queen)getTablePiece(x,y)).calcMove();
		for(int i = 0; i < moves.length; i++){
			if(rookBishopQueenMoves(moves[i],x,y) == 1){
				ArrayList<Integer> pos = new ArrayList<Integer>();
				pos.add(x + moves[i][0]);
				pos.add(y + moves[i][1]);
				matrix.add(pos);
			}else{
				if(rookBishopQueenMoves(moves[i],x,y) == -1){
					i = determineIndexForQueen(i);
				}

			}
		}
		return matrix;
	}

	public ArrayList<ArrayList<Integer>> pawnSuggestions(int x, int y) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		int[][] moves = ((Pawn)getTablePiece(x,y)).calcMove();
		for(int i = 0; i < moves.length; i++){
			if(getTablePiece(x,y).getColor() == PieceColor.BLACK){
				if(pawnBlackMoves(moves[i],x,y)){
					ArrayList<Integer> pos = new ArrayList<Integer>();
					pos.add(x + moves[i][0]);
					pos.add(y + moves[i][1]);
					matrix.add(pos);
				}
			}else{
				if(pawnWhiteMoves(moves[i],x,y)){
					ArrayList<Integer> pos = new ArrayList<Integer>();
					pos.add(x + moves[i][0]);
					pos.add(y + moves[i][1]);
					matrix.add(pos);
					pawnWhiteMoves(moves[i],x,y);
				}
			}
		}
		for(int i = 0; i < matrix.size(); i ++){
				System.out.println(matrix.get(i));
		}
		return matrix;
	}

	public boolean knightMoves(int[] pos, int x, int y) { // falta capturar.
		if(rangeOfTable(pos,x,y)){
			if(getTablePiece(x + pos[0], y + pos[1]) != null){
				if(getTablePiece(x,y).getColor() == getTablePiece(x + pos[0], y + pos[1]).getColor()){
					return false;
				}else{
					//Captura
					return true;
				}
			}else{
				return true;
			}
		}else{
			return false;
		}
	}

	public int rookBishopQueenMoves(int[] pos, int x, int y) {
		if(rangeOfTable(pos,x,y)){
			if(getTablePiece(x + pos[0], y + pos[1]) != null){
				if(getTablePiece(x,y).getColor() == getTablePiece(x + pos[0], y + pos[1]).getColor()){
					return -1;
				}else{
					return 1;
				}
			}else{
				return 1;
			}
		}else{
			return 0;
		}
	}

	public boolean kingMoves(int[] pos, int x, int y) {
		if(rangeOfTable(pos, x,y)){
			if(getTablePiece(x + pos[0], y + pos[1]) != null){
				if(getTablePiece(x,y).getColor() == getTablePiece(x + pos[0], y + pos[1]).getColor()){
					return false;
				}else{
					//Captura
					return true;
				}
			}else{
				return true;
			}
		}else{
			return false;
		}
	}

	public boolean pawnBlackMoves(int[] pos, int x, int y) { // falta capturar.
		if(rangeOfTable(pos, x, y)){
			if( y < y + pos[1] ){
				if(getTablePiece(x + pos[0], y + pos[1]) != null){
					if(getTablePiece(x + pos[0], y + pos[1]).getColor() == PieceColor.WHITE){
						return true;
					}else{
						//aqui se captura;
						return false;
					}
				}else{
					if(isDiagonal(x, y, x+pos[0], y+pos[1])){
						return false;
					}else{
						if(isDoubleForward(y, y+pos[1]) && firstTurn(x,y)){
							return true;
						}else{
							if(isStepForward(y, y+pos[1])){
								return true;
							}else{
								return false;
							}
						}
					}
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	public boolean pawnWhiteMoves(int[] pos, int x, int y) { // falta capturar.
		if(rangeOfTable(pos, x, y)){
			if( y > y + pos[1] ){
				if(getTablePiece(x + pos[0], y + pos[1]) != null){
					if(getTablePiece(x + pos[0], y + pos[1]).getColor() == PieceColor.BLACK){
						return true;
					}else{
						return false;
					}
				}else{
					if(isDiagonal(x, y, x+pos[0], y+pos[1])){
						return false;
					}else{
						if(isDoubleForward(y, y+pos[1]) && firstTurn(x,y)){
							return true;
						}else{
							if(isStepForward(y, y+pos[1])){
								return true;
							}else{
								return false;
							}
						}
					}
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	public boolean isDiagonal(int x, int y, int postx, int posty){
		if( y+1 == posty && (x+1 == postx || x-1 == postx)){
			return true;
		}else{
			if( y-1 == posty && (x+1 == postx || x-1 == postx)){
				return true;
			}else{
				return false;
			}
		}
	}

	public boolean firstTurn(int x, int y){
		if(((Pawn)getTablePiece(x,y)).isFirstTurn()){
			return true;
		}else{
			return false;
		}
	}

	public boolean isDoubleForward(int y, int posty){
		if(y+2 == posty || y-2 == posty){
			return true;
		}else{
			return false;
		}
	}


	public boolean isStepForward(int y, int posty){
		if(y+1 == posty || y-1 == posty){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void initTableWithPieces() {
		Piece BlackKing = new King(PieceColor.BLACK);
		Piece BlackQueen = new Queen(PieceColor.BLACK);

		Piece BlackKnight1 = new Knight(PieceColor.BLACK);
		Piece BlackKnight2 = new Knight(PieceColor.BLACK);

		Piece BlackBishop1 = new Bishop(PieceColor.BLACK);
		Piece BlackBishop2 = new Bishop(PieceColor.BLACK);

		Piece BlackRook1 = new Rook(PieceColor.BLACK);
		Piece BlackRook2 = new Rook(PieceColor.BLACK);

		Piece BlackPawn1 = new Pawn(PieceColor.BLACK);
		Piece BlackPawn2 = new Pawn(PieceColor.BLACK);
		Piece BlackPawn3 = new Pawn(PieceColor.BLACK);
		Piece BlackPawn4 = new Pawn(PieceColor.BLACK);
		Piece BlackPawn5 = new Pawn(PieceColor.BLACK);
		Piece BlackPawn6 = new Pawn(PieceColor.BLACK);
		Piece BlackPawn7 = new Pawn(PieceColor.BLACK);
		Piece BlackPawn8 = new Pawn(PieceColor.BLACK);

		// Black Rook Positioning
		this.table[0][0] = BlackRook1;
		this.table[0][7] = BlackRook2;

		// Black Knight Positioning
		this.table[0][1] = BlackKnight1;
		this.table[0][6] = BlackKnight2;

		// Black Bishop Positioning
		this.table[0][2] = BlackBishop1;
		this.table[0][5] = BlackBishop2;

		// Black Queen Positioning
		this.table[0][3] = BlackQueen;

		// Black King Positioning
		this.table[0][4] = BlackKing;

		// Black Pawn Positioning
		this.table[1][0] = BlackPawn1;
		this.table[1][1] = BlackPawn2;
		this.table[1][2] = BlackPawn3;
		this.table[1][3] = BlackPawn4;
		this.table[1][4] = BlackPawn5;
		this.table[1][5] = BlackPawn6;
		this.table[1][6] = BlackPawn7;
		this.table[1][7] = BlackPawn8;

		Piece WhiteKing = new King(PieceColor.WHITE);
		Piece WhiteQueen = new Queen(PieceColor.WHITE);

		Piece WhiteKnight1 = new Knight(PieceColor.WHITE);
		Piece WhiteKnight2 = new Knight(PieceColor.WHITE);

		Piece WhiteBishop1 = new Bishop(PieceColor.WHITE);
		Piece WhiteBishop2 = new Bishop(PieceColor.WHITE);

		Piece WhiteRook1 = new Rook(PieceColor.WHITE);
		Piece WhiteRook2 = new Rook(PieceColor.WHITE);

		Piece WhitePawn1 = new Pawn(PieceColor.WHITE);
		Piece WhitePawn2 = new Pawn(PieceColor.WHITE);
		Piece WhitePawn3 = new Pawn(PieceColor.WHITE);
		Piece WhitePawn4 = new Pawn(PieceColor.WHITE);
		Piece WhitePawn5 = new Pawn(PieceColor.WHITE);
		Piece WhitePawn6 = new Pawn(PieceColor.WHITE);
		Piece WhitePawn7 = new Pawn(PieceColor.WHITE);
		Piece WhitePawn8 = new Pawn(PieceColor.WHITE);

		// White Rook positioning
		this.table[7][0] = WhiteRook1;
		this.table[7][7] = WhiteRook2;

		// White Knight Positioning
		this.table[7][1] = WhiteKnight1;
		this.table[7][6] = WhiteKnight2;

		// Black Bishop Positioning
		this.table[7][2] = WhiteBishop1;
		this.table[7][5] = WhiteBishop2;

		// White Queen Positioning
		this.table[7][3] = WhiteQueen;

		// White King Positioning
		this.table[7][4] = WhiteKing;

		// White Pawn Positioning
		this.table[6][0] = WhitePawn1;
		this.table[6][1] = WhitePawn2;
		this.table[6][2] = WhitePawn3;
		this.table[6][3] = WhitePawn4;
		this.table[6][4] = WhitePawn5;
		this.table[6][5] = WhitePawn6;
		this.table[6][6] = WhitePawn7;
		this.table[6][7] = WhitePawn8;
	}
}
