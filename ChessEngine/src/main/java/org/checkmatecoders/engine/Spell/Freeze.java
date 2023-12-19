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
        super.duration = 4;
        
        //TODO Auto-generated constructor stub
    }
    public int getSize(){
        return size;
    }
    @Override
    public boolean checkValidity() {
        
        return(board.getPiece(getTargetedPosition()) !=null && getTargetedPosition().x >0 && getTargetedPosition().y >0 && getTargetedPosition().x < 8 && getTargetedPosition().y < 8 ); 
       
    }
    
    @Override
    public void spellAction() {
        // TODO Auto-generated method stub
        if(checkValidity()){

            // deactivation (freeze) of cells the position being the center
            
            
                
                    if(duration>0){ //deactivation of piece on that field
                         Position temp = new Position(getTargetedPosition().x, getTargetedPosition().y);
                        for(int i =(-(size-1)/2); i<=((size-1)/2) ; i++){
                            for(int j =(-(size-1)/2); j<=((size-1)/2) ;j++){
                            getTargetedPosition().changePosition(new Position(temp.x+i,temp.x+j ));

                            
                                if(checkValidity()){

                            board.getPiece(getTargetedPosition()).canMove = false;
                            System.out.println("I am frozen" + getTargetedPosition());;
                                 }
                            }   
                        }
                    }
                    else if( duration== 0){
                        Position temp = new Position(getTargetedPosition().x, getTargetedPosition().y);
                       for(int i =(-1); i<=(+1) ; i++){
                            for(int j =(-1); j<=(1) ;j++){
                             getTargetedPosition().changePosition(new Position(temp.x+i,temp.x+j ));
                            
                                if(checkValidity()){

                                board.getPiece(getTargetedPosition()).canMove = true;
                                System.out.println("I am defrozen" + getTargetedPosition());;
                                }
                             }
                        }

                    }
                    
         
         }
 }
}


