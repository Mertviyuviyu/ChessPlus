package org.checkmatecoders.engine.Piece;

import org.checkmatecoders.engine.Board;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{

    public King(Color color, Board board, Position position) {
        super(color, board, position);
    }

    @Override
    public List<Position> getValidMoves() {
        
        List<Position> allMoves = new ArrayList<Position>();
        if(canMove && capturable){
        allMoves.add(new Position(this.position.x + 1, this.position.y + 1));
        allMoves.add(new Position(this.position.x + 1, this.position.y -1));
        allMoves.add(new Position(this.position.x + 1, this.position.y ));

        allMoves.add(new Position(this.position.x - 1, this.position.y + 1));
        allMoves.add(new Position(this.position.x - 1, this.position.y -1));
        allMoves.add(new Position(this.position.x - 1, this.position.y));

        allMoves.add(new Position(this.position.x, this.position.y + 1));
        allMoves.add(new Position(this.position.x, this.position.y -1));
        allMoves.add(new Position(this.position.x, this.position.y));


        allMoves.removeIf(i -> i.x < 0 || i.x > 7 || i.y < 0 || i.y > 7);

        allMoves.removeIf(i -> {
            Piece temp = this.board.getPiece(i);
            if (temp == null)
                return false;
            if (temp.color != this.color)
                return false;
            return true;
        });
    }

        return allMoves;
    }
}
