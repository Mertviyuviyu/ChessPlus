package org.checkmatecoders.frontend;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import javax.swing.JPanel;

import org.checkmatecoders.engine.Board;
import org.checkmatecoders.engine.Piece.Piece;
import org.checkmatecoders.engine.Spell.Freeze;
import org.checkmatecoders.engine.Spell.Spell;
import org.checkmatecoders.engine.Spell.Swap;

public class SpellPanel extends JPanel {
     public final int cols = 6;
    public final int rows = 1;

    public Piece chosenPiece;
    public Spell choosenSpell;
    public org.checkmatecoders.engine.Piece.Color turn;
    public SpellListener spellListener;
    public Board board;
    

    public SpellPanel(){
        setPreferredSize(new Dimension(cols* Resources.SPELL_SIZE ,rows* Resources.SPELL_SIZE));
        board = new Board();
        board.resetToStart();
        spellListener = new SpellListener(board,this);
        this.addMouseListener(spellListener);
        this.addMouseMotionListener(spellListener);
        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        

        //Print the spell deck (only player's deck as it will require interface and interactions //I guess the other deck which shows opponents deck(on the top of the board) will be only indicator which will not be GUI,)
        
        g2.setColor(Color.PINK);
        g2.fillRect( 0 ,0 , cols*(2*Resources.SPELL_SIZE), 10 + rows*Resources.SPELL_SIZE);
        
        
        
        
        showSpellFrame(g);
        repaint();
    }
    public void showSpellFrame(Graphics g){
        
        
        
        for (Spell s : board.spells) {
            
           
                if(s instanceof Freeze){ 
                g.drawImage(Resources.freeze, 20 + s.xPos , 10 + s.yPos , null);
                
                }
                if(s instanceof Swap){ 
                g.drawImage(Resources.swap,20 + s.xPos ,10 + s.yPos , null);
                
                } 
            
        }
    }
    public void drawSpellEffect(Graphics g){

}
}
