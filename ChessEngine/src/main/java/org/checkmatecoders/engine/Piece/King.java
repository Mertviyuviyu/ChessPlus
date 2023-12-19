package org.checkmatecoders.engine.Piece;

import org.checkmatecoders.engine.Board;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class King extends Piece{

    public King(Color color, Board board, Position position) {
        super(color, board, position);

    }

    @Override
    public List<Position> checkDirection() {
        return new ArrayList<Position>();
    }

    @Override
    public List<Position> getValidMoves() {
        
        List<Position> allMoves = new ArrayList<Position>();
        List<Position> allNewMoves = new ArrayList<Position>();
        if(canMove){
            //KING IGNORES THE SHIELD
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


        if(board.check().size()==0){

            return allMoves;
        }
        //System.out.println("Dir"+this.board.getPiece(board.check().get(0)).checkDirection());
        //System.out.println("allM"+allMoves);
        for(Position i : allMoves){
            if(i.equals(board.check().get(0))){
                allNewMoves.add(i);
                //System.out.println("checkposadded");
            }
            else{
                boolean notEqual = true;
                for(int ii = 0 ; ii<this.board.getPiece(board.check().get(0)).getValidMoves2().size();ii++){
                    if(this.board.getPiece(board.check().get(0)).getValidMoves2().get(ii).equals(i)){
                        notEqual = false;
                    }
                }
                if(notEqual){
                    //System.out.println("added"+i);
                    allNewMoves.add(i);
                }
            }

        }
        //System.out.println("New"+allNewMoves);
        //System.out.println(board.check().size());
        return allNewMoves;
    }
    @Override
    public List<Position> getValidMoves2() {

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
