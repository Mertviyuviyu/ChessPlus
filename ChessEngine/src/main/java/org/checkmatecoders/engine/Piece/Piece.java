package org.checkmatecoders.engine.Piece;

import org.checkmatecoders.engine.Board;

import javax.swing.*;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Piece {

    public Color color;
    public Image pieceImg;
    public Position position;
    public Board board;

    public boolean capturable;
    public boolean canMove;

    public int xPos, yPos;


    public Piece(Color color, Board board, Position position) {
        this.color = color;
        this.board = board;
        this.position = position;
        xPos = position.x * 70;
        yPos = position.y * 70;

        this.capturable = true;
        this.canMove = true;

    }

    public void move(Position p) {
        this.position.changePosition(p);
        Color c = this.color;
        if(c == Color.White){
            c = Color.Black;
        }
        else {
            c = Color.White;
        }
        Color winner;
        boolean lost = true;
        for(Piece i : board.pieces){
            if(!(i instanceof King)){
                if(!i.getValidMoves().isEmpty() && i.color==c){
                    lost = false;
                }
            }
        }
        if(lost){
            if(c == Color.White){
                winner = Color.Black;
            }
            else {
                winner = Color.White;
            }
            JOptionPane.showMessageDialog(null, "Winner is "+winner);
            board.resetToStart();
        }
    }


    public boolean isInBounds(Position move) {
        return move.x >= 0 && move.x <= 7 && move.y >= 0 && move.y <= 7;
    }





    public abstract List<Position> checkDirection();

    public abstract List<Position> getValidMoves();
    public abstract List<Position> getValidMoves2();

}
