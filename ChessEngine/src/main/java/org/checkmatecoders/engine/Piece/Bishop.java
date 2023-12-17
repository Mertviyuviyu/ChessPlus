package org.checkmatecoders.engine.Piece;

import org.checkmatecoders.engine.Board;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{

    public Bishop(Color color, Board board, Position position) {
        super(color, board, position);
    }
    @Override
    public List<Position> getValidMoves() {
        List<Position> allMoves = new ArrayList<Position>();
        //Up right
        if(canMove){
        for(int i = 1; this.position.x + i < 8 && this.position.y + i < 8; i++){
            Position pos = new Position(this.position.x + i, this.position.y + i);
            if(isInBounds(pos)){
                if(isTherePiece(pos)){
                    if(board.getPiece(pos).color != this.color){
                        if(board.getPiece(pos).capturable)
                        allMoves.add(pos);
                        else{
                            break;
                        }
                    }
                    break;
                }
                allMoves.add(pos);
            }
        }
        //Up left
        for(int i = 1; this.position.x - i >= 0 && this.position.y + i < 8; i++){
            Position pos = new Position(this.position.x - i, this.position.y + i);
            if(isInBounds(pos)){
                if(isTherePiece(pos)){
                    if(board.getPiece(pos).color != this.color){
                        if(board.getPiece(pos).capturable)
                        allMoves.add(pos);
                        else{
                            break;
                        }
                    }
                    break;
                }
                allMoves.add(pos);
            }
        }
        //Down right
        for (int i = 1; this.position.x + i < 8 && this.position.y - i >= 0; i++) {
            Position pos = new Position(this.position.x + i, this.position.y - i);
            if (isInBounds(pos)) {
                if (isTherePiece(pos)) {
                    if (board.getPiece(pos).color != this.color) {
                        if(board.getPiece(pos).capturable)
                        allMoves.add(pos);
                        else{
                            break;
                        }
                    }
                    break;
                }
                allMoves.add(pos);
            }
        }
        //Down left
        for (int i = 1; this.position.x - i >= 0 && this.position.y - i >= 0; i++) {
            Position pos = new Position(this.position.x - i, this.position.y - i);
            if (isInBounds(pos)) {
                if (isTherePiece(pos)) {
                    if (board.getPiece(pos).color != this.color) {
                        if(board.getPiece(pos).capturable)
                        allMoves.add(pos);
                        else{
                            break;
                        }
                    }
                    break;
                }
                allMoves.add(pos);
            }
        }
    }
        return allMoves;
    }
}
