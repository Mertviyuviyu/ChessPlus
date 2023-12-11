package org.checkmatecoders.engine.Piece;

import org.checkmatecoders.engine.Board;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{
    public Rook(Color color, Board board, Position position) {
        super(color, board, position);
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
        return allMoves;
    }
}
