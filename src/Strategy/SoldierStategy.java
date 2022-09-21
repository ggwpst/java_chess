package Strategy;

import Piece.ChessPiece;

import java.util.Set;

public class SoldierStategy  implements MoveStrategy{
    private int curX;
    private int curY;
    private char side;
    private boolean firstMove = true;

    public SoldierStategy(int curX, int curY,char side) {
        this.curX = curX;
        this.curY = curY;
        this.side = side;
    }



    @Override
    public boolean move(int x, int y, Set<ChessPiece> chessPieces) {
        //���u����
        if(curY==y){
            if(isOverPiece(x,y,side,chessPieces))
                return false;
            switch (side){
                case 'B': {
                    if(isFirstMove() && (x==curX+1 || curX+2==x)){
                        setFirstMove(!firstMove);
                        curY = y;
                        curX = x;
                        return true;
                    }
                    else if(!isFirstMove() && curX+1==x){
                        curY = y;
                        curX = x;
                        return true;
                    }
                    break;
                }

                case 'W':{
                    if(isFirstMove() && (x==curX-1||x==curX-2)){
                        setFirstMove(!firstMove);
                        curY = y;
                        curX = x;
                        return true;
                    }
                    else if(!isFirstMove() && curX-1==x){
                        curY = y;
                        curX = x;
                        return true;
                    }
                    break;
                }
            }
        }

        //�Y�l����
        for(ChessPiece e:chessPieces){
            if(Math.abs(e.getRow()-curY)==1){
                if(e.getCol()-curX==1&&e.getSide()=='W'||
                curX-e.getCol()==1&&e.getSide()=='B'){
                    curY = y;
                    curX = x;
                    return true;
                }

            }
        }

        return false;
    }

    public boolean isOverPiece(int x, int y,char side,Set<ChessPiece> chessPieces){
        for(ChessPiece e:chessPieces){
            if(e.getCol()==x && e.getRow()==y && !e.isSelected()){
                return true;
            }
        }
        return false;
    }



    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    public int getCurX() {
        return curX;
    }

    public void setCurX(int curX) {
        this.curX = curX;
    }

    public int getCurY() {
        return curY;
    }

    public void setCurY(int curY) {
        this.curY = curY;
    }
}