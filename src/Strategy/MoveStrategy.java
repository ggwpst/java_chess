package Strategy;

import Piece.ChessPiece;

import java.util.Set;

public interface MoveStrategy {
    boolean move(int x, int y, Set<ChessPiece> chessPieces);
}