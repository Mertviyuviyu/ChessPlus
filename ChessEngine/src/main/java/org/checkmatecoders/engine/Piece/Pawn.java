package org.checkmatecoders.engine.Piece;

import org.checkmatecoders.engine.Board;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{

    public boolean isFirstMove;
    public int movingWay;
    public Pawn(Color color, Board board, Position position) {
        super(color, board, position);
        isFirstMove = true;
        if(color == Color.White){
            movingWay = -1;
        }
        else{
            movingWay = 1;
        }
    }
    @Override
    public void move(Position p){
        this.position.changePosition(p);
        this.isFirstMove = false;
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
        }
    }

    @Override
    public List<Position> checkDirection() {
        return null;
    }

    @Override
    public List<Position> getValidMoves() {
        List<Position> allMoves = new ArrayList<Position>();
        List<Position> allNewMoves = new ArrayList<Position>();
        if(canMove){
        if(isFirstMove && board.getPiece(new Position(this.position.x,this.position.y + movingWay)) == null && board.getPiece(new Position(this.position.x,this.position.y + 2*movingWay)) == null){
            allMoves.add(new Position(this.position.x, this.position.y +2*movingWay));
        }
        if(board.getPiece(new Position(this.position.x,this.position.y + movingWay) ) == null){
            allMoves.add(new Position(this.position.x, this.position.y + movingWay));
        }

        if(board.getPiece(new Position(this.position.x +1,this.position.y + movingWay)) != null){
            Piece p = board.getPiece(new Position(this.position.x +1,this.position.y + movingWay));
            if(p.color != this.color && p.capturable){
                allMoves.add(new Position(this.position.x+1, this.position.y + movingWay));
            }
        }
        if(board.getPiece(new Position(this.position.x - 1,this.position.y + movingWay)) != null){
            Piece p = board.getPiece(new Position(this.position.x -1,this.position.y + movingWay));
            if(p.color != this.color && p.capturable){
                allMoves.add(new Position(this.position.x-1, this.position.y + movingWay));
            }
        }
    }
        if(board.check().size()==0){
            return allMoves;

        }
        if(board.check().size()>1){
            return new ArrayList<Position>();
        }
        for(Position i : allMoves){
            if(i.equals(board.check().get(0)) || this.board.getPiece(board.check().get(0)).checkDirection().contains(i)){
                allNewMoves.add(i);
            }
        }
        return allNewMoves;

    }
    @Override
    public List<Position> getValidMoves2() {
        List<Position> allMoves = new ArrayList<Position>();
        if(canMove){
            if(isFirstMove && board.getPiece(new Position(this.position.x,this.position.y + movingWay)) == null && board.getPiece(new Position(this.position.x,this.position.y + 2*movingWay)) == null){
                allMoves.add(new Position(this.position.x, this.position.y +2*movingWay));
            }
            if(board.getPiece(new Position(this.position.x,this.position.y + movingWay) ) == null){
                allMoves.add(new Position(this.position.x, this.position.y + movingWay));
            }

            if(board.getPiece(new Position(this.position.x +1,this.position.y + movingWay)) != null){
                Piece p = board.getPiece(new Position(this.position.x +1,this.position.y + movingWay));
                if(p.color != this.color && p.capturable){
                    allMoves.add(new Position(this.position.x+1, this.position.y + movingWay));
                }
            }
            if(board.getPiece(new Position(this.position.x - 1,this.position.y + movingWay)) != null){
                Piece p = board.getPiece(new Position(this.position.x -1,this.position.y + movingWay));
                if(p.color != this.color && p.capturable){
                    allMoves.add(new Position(this.position.x-1, this.position.y + movingWay));
                }
            }
        }
        return allMoves;
    }
}
