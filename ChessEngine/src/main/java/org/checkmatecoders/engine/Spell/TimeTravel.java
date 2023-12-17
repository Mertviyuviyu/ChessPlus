package org.checkmatecoders.engine.Spell;

import org.checkmatecoders.engine.Board;
import org.checkmatecoders.engine.Piece.Position;

public class TimeTravel extends Spell {

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
        // TODO Auto-generated method stub
        
    }
    
}
