package org.checkmatecoders.engine;

import org.checkmatecoders.engine.Piece.Piece;
import org.checkmatecoders.engine.Piece.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class Board {
    public List<Piece> pieces;
    public List<Runnable> listeners;


    public Board(){
        pieces = new ArrayList<>();
        listeners = new ArrayList<>();
    }

    public Piece getPiece(Position position) {
        for (Piece i: pieces) {
            if (i.position == position) {
                return i;
            }
        }
        return null;
    }

    public void movePiece(Position p1, Position p2){
        getPiece(p1).move(p2);
        listeners.forEach(i -> i.run());
    }
    public void register(Runnable listener){
        listeners.add(listener);
    }
}
