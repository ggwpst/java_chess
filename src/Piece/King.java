package Piece;

import Strategy.PieceType;
import Strategy.KingStrategy;

public class King extends ChessPiece {
    public King(PieceType type, int row, int col) {
        super(type, row, col);
        setMoveStrategy(new KingStrategy(getCol(),getRow()));
    }
}