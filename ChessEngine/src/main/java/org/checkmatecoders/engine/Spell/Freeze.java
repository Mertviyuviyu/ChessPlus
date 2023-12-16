package org.checkmatecoders.engine.Spell;

import org.checkmatecoders.engine.Board;
import org.checkmatecoders.engine.Piece.Piece;
import org.checkmatecoders.engine.Piece.Position;

public class Freeze extends Spell {
int size;


final int freezeTime = 3;

    public Freeze(Board board, int amount, int cooldown, int size, Position position) {
        super(board, amount, cooldown, position);
        this.size = size;
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean checkValidity() {
        //will use no mather how the chess-board condition is
        return( amount > 0); 
       
    }

    @Override
    public void spellAction() {
        // TODO Auto-generated method stub
        if(checkValidity()){
            for(int i = freezeTime; i>0; i--){
               
                // deactivation (freeze) of cells the position being the center
                



            super.currentlyUsed = false;
            }
        currentlyUsed = false;
        }
    }
    
}
