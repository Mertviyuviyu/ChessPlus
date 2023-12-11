package org.checkmatecoders.engine.Piece;

import org.checkmatecoders.engine.Board;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{

    public Queen(Color color, Board board) {
        super(color, board);
    }

    @Override
    public List<Position> getValidMoves() {
        List<Position> allMoves = new ArrayList<Position>();
        //Move Right
        for(int x = this.position.x + 1 ; x < 8 ; x++){
            Position pos = new Position(x, this.position.y);
            if(isInBounds(pos)){
                if(isTherePiece(pos)){
                    if(board.getPiece(pos).color != this.color){
                        allMoves.add(pos);
                    }
                    break;
                }
                allMoves.add(pos);
            }
        }
        //Move Left
        for(int x = this.position.x - 1 ; x >= 0 ; x--){
            Position pos = new Position(x, this.position.y);
            if(isInBounds(pos)){
                if(isTherePiece(pos)){
                    if(board.getPiece(pos).color != this.color){
                        allMoves.add(pos);
                    }
                    break;
                }
                allMoves.add(pos);
            }
        }
        //Move Down
        for(int y = this.position.y - 1 ; y >= 0 ; y--){
            Position pos = new Position(this.position.x, y);
            if(isInBounds(pos)){
                if(isTherePiece(pos)){
                    if(board.getPiece(pos).color != this.color){
                        allMoves.add(pos);
                    }
                    break;
                }
                allMoves.add(pos);
            }
        }
        //Move Up
        for(int y = this.position.y + 1 ; y < 8 ; y++){
            Position pos = new Position(this.position.x, y);
            if(isInBounds(pos)){
                if(isTherePiece(pos)){
                    if(board.getPiece(pos).color != this.color){
                        allMoves.add(pos);
                    }
                    break;
                }
                allMoves.add(pos);
            }
        }
        //Up right
        for(int i = 1; this.position.x + i < 8 && this.position.y + i < 8; i++){
            Position pos = new Position(this.position.x + i, this.position.y + i);
            if(isInBounds(pos)){
                if(isTherePiece(pos)){
                    if(board.getPiece(pos).color != this.color){
                        allMoves.add(pos);
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
                        allMoves.add(pos);
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
                        allMoves.add(pos);
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
                        allMoves.add(pos);
                    }
                    break;
                }
                allMoves.add(pos);
            }
        }
        return allMoves;
    }
}
