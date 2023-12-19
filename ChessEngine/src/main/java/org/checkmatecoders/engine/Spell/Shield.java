package org.checkmatecoders.engine.Spell;

import org.checkmatecoders.engine.Board;
import org.checkmatecoders.engine.Piece.Piece;
import org.checkmatecoders.engine.Piece.Position;

public class Shield extends Spell {

    public Shield(Board board, int amount, int cooldown, Position position) {
        super(board, amount, cooldown, position);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean checkValidity() {
        // TODO Auto-generated method stub
        return(board.getPiece(getTargetedPosition()) != null);
    }

    @Override
    public void spellAction() {
        // TODO Auto-generated method stub
        if(checkValidity()){
            if(duration>0)
            board.getPiece(getTargetedPosition()).capturable = false;
            
            currentlyUsed = true;

            if(duration == 0){
            board.getPiece(getTargetedPosition()).capturable = true;
            currentlyUsed = false;
            board.initializeSpells();
            System.out.println("Iam not protected");
        }
            
        }
        
    }
    
}
