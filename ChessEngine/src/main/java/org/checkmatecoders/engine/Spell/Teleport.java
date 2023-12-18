package org.checkmatecoders.engine.Spell;

import org.checkmatecoders.engine.Board;
import org.checkmatecoders.engine.Piece.Position;

public class Teleport extends Spell {
private Position choosenPosition;
    public Teleport(Board board, int amount, int cooldown, Position position) {
        super(board, amount, cooldown, position);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean checkValidity() {
        return (board.getPiece(choosenPosition)  != null && board.getPiece(getTargetedPosition()) == null);
    }

    @Override
    public void spellAction() {
        // TODO Auto-generated method stub
        if(checkValidity()){
            board.movePiece(choosenPosition, getTargetedPosition());
        }
    }
    public void setChoosenPosition(Position cPosition){
        choosenPosition = cPosition;
    }
    public Position getChoosenPosition(){
        return choosenPosition;
        
    }
}
