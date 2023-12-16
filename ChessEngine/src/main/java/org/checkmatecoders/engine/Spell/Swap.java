package org.checkmatecoders.engine.Spell;

import org.checkmatecoders.engine.Board;
import org.checkmatecoders.engine.Piece.Piece;
import org.checkmatecoders.engine.Piece.Position;

public class Swap extends Spell {
private Position targetedPosition;
private Position choosenPosition;
    public Swap(Board board, int amount, int cooldown, Position position) {
        super(board, amount, cooldown, position);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean checkValidity() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void spellAction() {
        // TODO Auto-generated method stub
        if(checkValidity()){
            Piece temp = board.getPiece(targetedPosition);
            Piece victim = board.getPiece(choosenPosition);
            Piece target = board.getPiece(targetedPosition);


            target.move(choosenPosition);
            victim.move(targetedPosition);
            
            System.out.println("Swapped");
        }
    }
    public void setTargetedPosition( Position tposition ){
        targetedPosition = tposition;

    }
    public void setChoosenPosition( Position cposition ){
        choosenPosition = cposition;

    }
    
    public Position getTargetedPosition(){
        return targetedPosition;
    }
     public Position getChoosenPosition(){
        return choosenPosition;
    }
}
