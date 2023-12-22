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
        return(board.getPiece(getTargetedPosition()) != null && getTargetedPosition().x >=0 && getTargetedPosition().y >=0 && getTargetedPosition().x < 8 && getTargetedPosition().y < 8);
    }

    @Override
    public void spellAction() {
        // Piece holding a shield cannot also move
        if(checkValidity()){
            if(duration>0)
            board.getPiece(getTargetedPosition()).capturable = false;
            board.getPiece(getTargetedPosition()).canMove = false;
            
            currentlyUsed = true;

            if(duration == 0){
            board.getPiece(getTargetedPosition()).capturable = true;
            board.getPiece(getTargetedPosition()).canMove = true;
            currentlyUsed = false;
            board.initializeSpells();
            //System.out.println("Iam not protected");
        }
            
        }
        
    }
    
}
