package org.checkmatecoders.engine.Spell;

import org.checkmatecoders.engine.Board;

public class TimeTravel extends Spell {

    public TimeTravel(Board board, int amount, int cooldown) {
        super(null, amount, cooldown);
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
        throw new UnsupportedOperationException("Unimplemented method 'spellAction'");
    }
    
}
