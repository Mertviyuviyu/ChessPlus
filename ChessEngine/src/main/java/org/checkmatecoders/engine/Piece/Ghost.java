package org.checkmatecoders.engine.Piece;

import java.util.ArrayList;
import java.util.List;

import org.checkmatecoders.engine.Board;

public class Ghost extends Piece {

    public Ghost(Color color, Board board, Position position) {
        super(color, board, position);
        capturable = false;
        canMove = false;
    }

    @Override
    public List<Position> getValidMoves() {
        // TODO Auto-generated method stub
            List<Position> allMoves = new ArrayList<Position>();
            return null;
    }
    
}
