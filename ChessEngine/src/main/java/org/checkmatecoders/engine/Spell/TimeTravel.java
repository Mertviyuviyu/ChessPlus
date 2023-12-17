package org.checkmatecoders.engine.Spell;

import java.util.List;

import org.checkmatecoders.engine.Board;
import org.checkmatecoders.engine.Piece.Piece;
import org.checkmatecoders.engine.Piece.Position;

public class TimeTravel extends Spell {
private Piece choosenPiece;    

    public TimeTravel(Board board, int amount, int cooldown, Position position) {
        super(board, amount, cooldown, position);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean checkValidity() {
        //will be used with no condition
        return( amount > 0); 
    }

    @Override
    public void spellAction() {
        // Instead of giving a second turn; allow player to move piece as if they moved them before;
        List<Position> moves = choosenPiece.getValidMoves();
            Position currentPosition = choosenPiece.position;
            for(Position pos: moves){
                if(pos.equals(getTargetedPosition())){
                    board.movePiece(currentPosition,getTargetedPosition());
                }
    }
}
public void setTimePiece(Position position){
    choosenPiece = board.getPiece(position);
}
public Piece getTimePiece(){
    return choosenPiece;
}
    
}
