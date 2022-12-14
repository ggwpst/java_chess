package Piece;

import Strategy.PieceType;
import Strategy.HorseStategy;

public class Horse extends ChessPiece{
    public Horse(PieceType type, int row, int col) {
        super(type, row, col);
        setMoveStrategy(new HorseStategy(getCol(),getRow()));
    }
}
