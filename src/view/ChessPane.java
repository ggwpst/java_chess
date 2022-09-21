package view;


import Strategy.PieceType;
import Piece.*;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.*;

public class ChessPane extends Pane {
    private Set<ChessPiece> chessPieces;
    private  ChessBoard chessBoard;
    private Canvas canvas;
    private GraphicsContext gc;

    public ChessPane(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
        setChessPiece();
        canvas = new Canvas(900,900);
        gc = canvas.getGraphicsContext2D();
        draw();
    }



    public void draw(){
        drawBoard();
        drawPiece();
        getChildren().add(canvas);
    }


    public void drawBoard(){
        gc.clearRect(0,0,900,900);
        double x = chessBoard.getStartX();
        double y = chessBoard.getStartY();
        double cell = chessBoard.getCellLength();


        boolean flag = false;
        for(int i=0;i<chessBoard.getRow();i++){
            flag = !flag;
            for(int j=0;j<chessBoard.getCol();j++){
                gc.setFill(flag? Color.valueOf("#B8860B"):Color.valueOf("F0E68C"));
                gc.fillRect(x+j*cell,y+i*cell,cell,cell);
                flag = !flag;
            }
        }



        gc.setStroke(Color.GRAY);
        gc.strokeRect(x,y,cell*chessBoard.getCol(),cell*chessBoard.getRow());

    }

    public void drawPiece(){
        double cell = chessBoard.getCellLength();
        chessPieces.forEach( e->{
            if(e.isSelected()){
                gc.setFill(Color.valueOf("#6495ED"));
                gc.fillRect(chessBoard.getStartX()+e.getCol()*cell,
                        chessBoard.getStartY()+e.getRow()*cell,
                        cell,cell);
            }

            System.out.println(e.getType().getUrl());
            Image image = new Image(e.getType().getUrl());
            gc.drawImage(image,
                    chessBoard.getStartX()+10 + e.getCol() * cell,
                    chessBoard.getStartY()+10 + e.getRow() * cell,
                    cell-20, cell-20);
        });
    }



    //�[�J�Ѥl
    public void setChessPiece() {
        chessPieces = new HashSet<>();
        chessPieces.add(new Car(PieceType.CARBLACK,0,0));
        chessPieces.add(new Horse(PieceType.HORSEBLACK,1,0));
        chessPieces.add(new Knight(PieceType.KNIGHTBLACK,2,0));
        chessPieces.add(new King(PieceType.KINGBLACK,3,0));
        chessPieces.add(new Queen(PieceType.QUEENBLACK,4,0));
        chessPieces.add(new Knight(PieceType.KNIGHTBLACK,5,0));
        chessPieces.add(new Horse(PieceType.HORSEBLACK,6,0));
        chessPieces.add(new Car(PieceType.CARBLACK,7,0));
        for(int i=0;i<8;i++){
            chessPieces.add(new Soldier(PieceType.SOLDIERBLACK,i,1));
        }


        chessPieces.add(new Car(PieceType.CARWHITE,0,7));
        chessPieces.add(new Horse(PieceType.HORSEWHITE,1,7));
        chessPieces.add(new Knight(PieceType.KNIGHTWHITE,2,7));
        chessPieces.add(new King(PieceType.KINGWHITE,3,7));
        chessPieces.add(new Queen(PieceType.QUEENWHITE,4,7));
        chessPieces.add(new Knight(PieceType.KNIGHTWHITE,5,7));
        chessPieces.add(new Horse(PieceType.HORSEWHITE,6,7));
        chessPieces.add(new Car(PieceType.CARWHITE,7,7));
        for(int i=0;i<8;i++){
            chessPieces.add(new Soldier(PieceType.SOLDIERWHITE,i,6));
        }
    }
    
    
	
	

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public Set<ChessPiece> getChessPieces() {
        return chessPieces;
    }

    public void setChessPieces(Set<ChessPiece> chessPieces) {
        this.chessPieces = chessPieces;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }
}