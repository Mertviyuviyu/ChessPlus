package org.checkmatecoders.engine.Piece;

import org.checkmatecoders.engine.Board;

import java.awt.Image;
import java.util.List;

public abstract class Piece {

    public Color color;
    public Image pieceImg;
    public Position position;
    public Board board;

    public Piece(Color color, Board board){
        this.color = color;
        this.board = board;
    }

    public abstract List<Position> getValidMoves();

}
