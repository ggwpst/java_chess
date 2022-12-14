package Piece;

import Strategy.PieceType;
import Strategy.CarStrategy;

public class Car extends ChessPiece {
    public Car(PieceType type, int row, int col) {
        super(type, row, col);
        setMoveStrategy(new CarStrategy(getCol(),getRow()));
    }
}
