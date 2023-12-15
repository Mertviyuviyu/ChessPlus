package org.checkmatecoders.engine.Spell;

import org.checkmatecoders.engine.Board;
import org.checkmatecoders.engine.Piece.Piece;
import org.checkmatecoders.engine.Piece.Position;

public class Swap extends Spell {
private Position targetedPosition;
    public Swap(Board board, int amount, int cooldown) {
        super(board, amount, cooldown);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean checkValidity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkValidity'");
    }

    @Override
    public void spellAction() {
        // TODO Auto-generated method stub
        if(checkValidity()){
            Piece temp = board.getPiece(super.position);
            Piece victim = board.getPiece(position);
            Piece target = board.getPiece(targetedPosition);

            victim = target;
            target = temp;

            


        }
    }
    
}
