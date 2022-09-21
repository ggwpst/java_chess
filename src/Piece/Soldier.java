package Piece;

import Strategy.PieceType;
import Strategy.SoldierStategy;

public class Soldier extends ChessPiece{
    public Soldier(PieceType type, int row, int col) {
        super(type, row, col);
        setMoveStrategy(new SoldierStategy(getCol(),getRow(),getSide()));
    }

}
