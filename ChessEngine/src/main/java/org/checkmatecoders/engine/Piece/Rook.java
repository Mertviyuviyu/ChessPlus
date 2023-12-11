package org.checkmatecoders.engine.Piece;

import org.checkmatecoders.engine.Board;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{
    public Rook(Color color, Board board) {
        super(color, board);
    }

    @Override
    public List<Position> getValidMoves() {
        List<Position> allMoves = new ArrayList<Position>();



        return allMoves;
    }
}
