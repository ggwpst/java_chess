package Piece;

import Strategy.PieceType;
import Strategy.QueenSrategy;

public class Queen extends ChessPiece {
    public Queen(PieceType type, int row, int col) {
        super(type, row, col);
        setMoveStrategy(new QueenSrategy(getCol(),getRow()));
    }
}