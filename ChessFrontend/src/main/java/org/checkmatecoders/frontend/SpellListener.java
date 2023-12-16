package org.checkmatecoders.frontend;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import org.checkmatecoders.engine.Board;
import org.checkmatecoders.engine.Piece.Color;
import org.checkmatecoders.engine.Piece.Piece;
import org.checkmatecoders.engine.Piece.Position;
import org.checkmatecoders.engine.Spell.Freeze;
import org.checkmatecoders.engine.Spell.Spell;
import org.checkmatecoders.engine.Spell.Swap;

public class SpellListener implements MouseListener, MouseMotionListener{
Board board;
SpellPanel spellPanel;
BoardPanel boardPanel;

    public SpellListener(Board board,SpellPanel spellPanel){
        this.board = board;
        this.spellPanel = spellPanel;
    }
    /*public void mousePressed(MouseEvent e) {
        int col = e.getX() / Resources.SPELL_SIZE;
        int row = e.getY() / Resources.SPELL_SIZE;

        
        Spell spellTry = board.getSpell(new Position(col, row));
        if(spellTry != null){
            spellPanel.choosenSpell = spellTry;
            System.out.println("I was chosen");

        for(Spell spll: board.spells){
            if( spll instanceof Swap){
                try{
                    int col1 = e.getX() / Resources.SQUARE_SIZE;
                    int row1 = e.getY() / Resources.SQUARE_SIZE;
                    if(spll.board.getPiece(new Position(col1, row1)) != null);
                    System.out.println( " First piece chosen");
                }finally{}
                
                int col2 = e.getX() / Resources.SQUARE_SIZE;
                int row2 = e.getY() / Resources.SQUARE_SIZE;
                ((Swap) spll).setTargetedPosition( new Position(col2, row2));
                System.out.println("I interfered!");

                spll.spellAction();
                }
            }
        }


    }
    */
    
    public void mousePressed(MouseEvent e) {
        int col = e.getX() / Resources.SPELL_SIZE;
        int row = e.getY() / Resources.SPELL_SIZE;
        
        Spell spellTry = board.getSpell(new Position(col, row));
        if (spellTry != null && spellTry instanceof Swap) {
            Spell swapSpell = spellTry;
    
            if (((Swap) swapSpell).getTargetedPosition() == null) {
                int col1 = e.getX() / Resources.SQUARE_SIZE;
                int row1 = e.getY() / Resources.SQUARE_SIZE;
    
                Position firstPosition = new Position(col1, row1);
                if (swapSpell.board.getPiece(firstPosition) != null) {
                    System.out.println("First piece chosen: " + firstPosition);
                    ((Swap) swapSpell).setTargetedPosition(firstPosition);
                }
            } else {
                int col2 = e.getX() / Resources.SQUARE_SIZE;
                int row2 = e.getY() / Resources.SQUARE_SIZE;
    
                Position secondPosition = new Position(col2, row2);
                if (swapSpell.board.getPiece(secondPosition) != null) {
                    System.out.println("Second piece chosen: " + secondPosition);
                    swapSpell.spellAction(); // Perform the spell action after both pieces are chosen
                    ((Swap) swapSpell).setTargetedPosition(null); // Reset targeted position for next use
                }
            }
        }
    }
    
    
    
    
    
    @Override
    public void mouseDragged(MouseEvent e) {
        if(spellPanel.choosenSpell != null){
            spellPanel.choosenSpell.xPos = e.getX() - Resources.SPELL_SIZE / 2;
            spellPanel.choosenSpell.yPos = e.getY() - Resources.SPELL_SIZE / 2;
        }
        else if(spellPanel.choosenSpell != null){
            spellPanel.choosenSpell.xPos = e.getX() - Resources.SPELL_SIZE / 2;
            spellPanel.choosenSpell.yPos = e.getY() - Resources.SPELL_SIZE / 2;
        }

    }
    @Override
    public void mouseReleased(MouseEvent e) {
        int col = e.getX() / Resources.SPELL_SIZE;
        int row = e.getY() / Resources.SPELL_SIZE;
        Position newPosition = new Position(col,row);
        if(spellPanel.choosenSpell != null){
            //List<Position> moves = spellPanel.choosenSpell.getValidMoves();
            Position currentPosition = spellPanel.choosenSpell.position;
            
            spellPanel.choosenSpell.xPos = spellPanel.choosenSpell.position.x * Resources.SPELL_SIZE;
            spellPanel.choosenSpell.yPos = spellPanel.choosenSpell.position.y * Resources.SPELL_SIZE;
            spellPanel.choosenSpell = null;
            spellPanel.repaint();
        }

    }
    

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    

    

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    








    
    }

