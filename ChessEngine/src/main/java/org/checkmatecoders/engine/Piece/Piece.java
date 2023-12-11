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
    public void move(Position p){
        this.position.changePosition(p);
    }
    public boolean isInBounds(Position move){
        return move.x >= 0 && move.x <= 7 && move.y >= 0 && move.y <= 7;
    }
    public boolean isTherePiece(Position move){
        Piece targetPiece = this.board.getPiece(move);
        return targetPiece != null;
    }
    public abstract List<Position> getValidMoves();

}
