package Piece;

import Strategy.PieceType;
import Strategy.KnightStrategy;

public class Knight extends ChessPiece {
    public Knight(PieceType type, int row, int col) {
        super(type, row, col);
        setMoveStrategy(new KnightStrategy(getCol(),getRow()));
    }
}