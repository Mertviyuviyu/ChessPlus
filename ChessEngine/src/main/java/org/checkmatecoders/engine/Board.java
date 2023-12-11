package org.checkmatecoders.engine;

import org.checkmatecoders.engine.Piece.Piece;
import org.checkmatecoders.engine.Piece.Position;

import java.util.List;
import java.util.stream.Collectors;

public class Board {
    public List<Piece> pieces;

    public Piece getPiece(Position position) {
        for (Piece i: pieces) {
            if (i.position == position) {
                return i;
            }
        }
        return null;
    }
}
