package Controller;

import Piece.ChessPiece;
import view.ChessBoard;
import view.ChessPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Stack;

public class ResetAction  implements EventHandler<ActionEvent>{
    private ChessPane chessPane;
    
    public ResetAction(ChessPane chessPane) {
        this.chessPane = chessPane;
    }

    @Override
    public void handle(ActionEvent e) {
        Stack<ChessPiece> stack = ReleaseAction.stack;
        if(!stack.empty()){
            chessPane.getChessPieces().removeIf(o->o.equals(stack.peek()));//�h����ӴѤl
            chessPane.getChessPieces().add(stack.pop());//�N�X�l���s�[�J
            
            chessPane.drawBoard();
            chessPane.drawPiece();
        }
    }
}
