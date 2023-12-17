package org.checkmatecoders.engine.Spell;


import java.util.ArrayList;
import java.util.List;

import org.checkmatecoders.engine.Board;
import org.checkmatecoders.engine.Piece.Ghost;
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
    public int getSize(){
        return size;
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

            // deactivation (freeze) of cells the position being the center
            
            
                if(getTargetedPosition().x != 0 && getTargetedPosition().y !=0){
                    if(!currentlyUsed){
                        if(board.getPiece(getTargetedPosition()) != null){
                    board.getPiece(getTargetedPosition()).capturable = false;
                    board.getPiece(getTargetedPosition()).canMove = false;
                        }
                }
                
                    else{
                    board.addPiece(new Ghost(null, board, position));
                    }
                }
            
        }
         
     }
 }
    


