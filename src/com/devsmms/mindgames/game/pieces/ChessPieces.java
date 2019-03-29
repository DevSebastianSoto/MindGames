package com.devsmms.mindgames.game.pieces;

public enum ChessPieces implements Pieces{
    WHITE_QUEEN, WHITE_KING, WHITE_BISHOP, WHITE_KNIGHT, WHITE_ROOK, WHITE_PAWN,
    BLACK_QUEEN, BLACK_KING, BLACK_BISHOP, BLACK_KNIGHT, BLACK_ROOK, BLACK_PAWN;

    @Override
    public String getIcon() {
        return null;
    }

    @Override
    public PieceColor getColor() {
        return null;
    }
}
