package org.checkmatecoders.engine.Spell;

import org.checkmatecoders.engine.Board;
import org.checkmatecoders.engine.Piece.Position;

public class Teleport extends Spell {

    public Teleport(Board board, int amount, int cooldown, Position position) {
        super(board, amount, cooldown, position);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean checkValidity() {
        return true;
    }

    @Override
    public void spellAction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'spellAction'");
    }
    
}
