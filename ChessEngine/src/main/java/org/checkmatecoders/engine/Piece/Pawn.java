package org.checkmatecoders.engine.Piece;

import org.checkmatecoders.engine.Board;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{

    public boolean isFirstMove;
    public int movingWay;
    public Pawn(Color color, Board board, Position position) {
        super(color, board, position);
        isFirstMove = true;
        if(color == Color.White){
            movingWay = -1;
        }
        else{
            movingWay = 1;
        }
    }
    @Override
    public void move(Position p){
        this.position.changePosition(p);
        this.isFirstMove = false;
    }
    @Override
    public List<Position> getValidMoves() {
        List<Position> allMoves = new ArrayList<Position>();
        if(isFirstMove && board.getPiece(new Position(this.position.x,this.position.y + movingWay)) == null && board.getPiece(new Position(this.position.x,this.position.y + 2*movingWay)) == null){
            allMoves.add(new Position(this.position.x, this.position.y +2*movingWay));
        }
        if(board.getPiece(new Position(this.position.x,this.position.y + movingWay)) == null){
            allMoves.add(new Position(this.position.x, this.position.y + movingWay));
        }

        if(board.getPiece(new Position(this.position.x +1,this.position.y + movingWay)) != null){
            Piece p = board.getPiece(new Position(this.position.x +1,this.position.y + movingWay));
            if(p.color != this.color){
                allMoves.add(new Position(this.position.x+1, this.position.y + movingWay));
            }
        }
        if(board.getPiece(new Position(this.position.x - 1,this.position.y + movingWay)) != null){
            Piece p = board.getPiece(new Position(this.position.x -1,this.position.y + movingWay));
            if(p.color != this.color){
                allMoves.add(new Position(this.position.x-1, this.position.y + movingWay));
            }
        }
        return allMoves;
    }
}
