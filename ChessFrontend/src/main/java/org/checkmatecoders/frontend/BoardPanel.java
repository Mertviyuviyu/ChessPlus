package org.checkmatecoders.frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.List;

import org.checkmatecoders.engine.Board;
import org.checkmatecoders.engine.Piece.*;
import org.checkmatecoders.engine.Spell.Freeze;
import org.checkmatecoders.engine.Spell.Shield;
import org.checkmatecoders.engine.Spell.Spell;
import org.checkmatecoders.engine.Spell.Swap;
import org.checkmatecoders.engine.Spell.TimeTravel;

public class BoardPanel extends JPanel {

    public final int cols = 8;
    public final int rows = 8;

    public Piece chosenPiece;
    public Spell choosenSpell;
    public org.checkmatecoders.engine.Piece.Color turn;
    public ChessListener chessListener;
    public Board board;
    

    public BoardPanel(){
        setPreferredSize(new Dimension(8* Resources.SQUARE_SIZE ,9* Resources.SQUARE_SIZE ));
        board = new Board();
        board.resetToStart();
        chessListener = new ChessListener(board,this);
        this.addMouseListener(chessListener);
        this.addMouseMotionListener(chessListener);
        turn = org.checkmatecoders.engine.Piece.Color.White;
    }
    public void nextTurn(){
        if(turn == org.checkmatecoders.engine.Piece.Color.White){
            turn =org.checkmatecoders.engine.Piece.Color.Black;
        }
        else{
            turn = org.checkmatecoders.engine.Piece.Color.White;
        }
        for (int i = 0; i < chessListener.activeSpellEffects.size(); i++) {
                Spell effect =chessListener.activeSpellEffects.get(i);
                effect.decrementDuration();
            
                if (effect.getDuration() <= 0) {
                    effect.spellAction();
                    chessListener.activeSpellEffects.remove(i);
                    i--; // Adjust index after removal
                }
            }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        //Prints the squares
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * Resources.SQUARE_SIZE;
                int y = row * Resources.SQUARE_SIZE;

                java.awt.Color squareColor = (row + col) % 2 == 0 ? new java.awt.Color(240,217,181) : new java.awt.Color(181,136,99);

                g2.setColor(squareColor);
                g2.fillRect(x, y, Resources.SQUARE_SIZE, Resources.SQUARE_SIZE);
            }
        }
        for( Piece p : board.pieces){
            if(!p.canMove){
            g2.setColor(new Color(51,153,255,126));
            g2.fillRect(p.xPos, p.yPos,Resources.SQUARE_SIZE, Resources.SQUARE_SIZE);
            }
            if(!p.capturable){
            g2.setColor(new Color(255, 215, 0,127)); 
            g2.fillRect(p.xPos, p.yPos,Resources.SQUARE_SIZE, Resources.SQUARE_SIZE);   
            }
        }

        if(chosenPiece != null && chosenPiece.color == turn){
            List<Position> moves = chosenPiece.getValidMoves();
            for(Position p: moves){
                g2.setColor(new Color(103,177,86,190));
                g2.fillRect(p.x * Resources.SQUARE_SIZE, p.y*Resources.SQUARE_SIZE, Resources.SQUARE_SIZE, Resources.SQUARE_SIZE);
            }
        }


        if( choosenSpell instanceof Freeze ){
                Position p = choosenSpell.position;
            
                    g2.setColor(new Color(51,153,255,126));
                    
                    g2.fillRect((p.x +1) * Resources.SQUARE_SIZE, (p.y-1)*Resources.SQUARE_SIZE, Resources.SQUARE_SIZE, Resources.SQUARE_SIZE);
                    g2.fillRect((p.x +1) * Resources.SQUARE_SIZE, p.y*Resources.SQUARE_SIZE, Resources.SQUARE_SIZE, Resources.SQUARE_SIZE);
                    g2.fillRect((p.x +1) * Resources.SQUARE_SIZE, (p.y+1)*Resources.SQUARE_SIZE, Resources.SQUARE_SIZE, Resources.SQUARE_SIZE);
                    g2.fillRect(p.x * Resources.SQUARE_SIZE, (p.y-1)*Resources.SQUARE_SIZE, Resources.SQUARE_SIZE, Resources.SQUARE_SIZE);
                    g2.fillRect(p.x * Resources.SQUARE_SIZE, p.y*Resources.SQUARE_SIZE, Resources.SQUARE_SIZE, Resources.SQUARE_SIZE);
                    g2.fillRect(p.x * Resources.SQUARE_SIZE, (p.y+1)*Resources.SQUARE_SIZE, Resources.SQUARE_SIZE, Resources.SQUARE_SIZE);
                    g2.fillRect((p.x -1) * Resources.SQUARE_SIZE, (p.y-1)*Resources.SQUARE_SIZE, Resources.SQUARE_SIZE, Resources.SQUARE_SIZE);
                    g2.fillRect((p.x -1) * Resources.SQUARE_SIZE, p.y*Resources.SQUARE_SIZE, Resources.SQUARE_SIZE, Resources.SQUARE_SIZE);
                    g2.fillRect((p.x -1)* Resources.SQUARE_SIZE, (p.y+1)*Resources.SQUARE_SIZE, Resources.SQUARE_SIZE, Resources.SQUARE_SIZE);

                    
                    }
                    
                
            
       

        //Print the spell deck (only player's deck as it will require interface and interactions //I guess the other deck which shows opponents deck(on the top of the board) will be only indicator which will not be GUI,)
        
        g2.setColor(Color.PINK);
        g2.fillRect( 0 ,575, 600, 600+Resources.SPELL_SIZE);
        
        
        
        drawPieces(g);
        showSpellFrame(g);
        //drawSpellEffect(g);
        repaint();
    }
    public void showSpellFrame(Graphics g){
        
        
        
        for (Spell s : board.spells) {
            
           
                if(s instanceof Freeze){ 
                g.drawImage(Resources.freeze, 20 + s.xPos ,  20 + s.yPos , null);
                
                }
                if(s instanceof Swap){ 
                g.drawImage(Resources.swap,20 + s.xPos , 20 + s.yPos , null);
                
                } 

                if(s instanceof Shield){ 
                g.drawImage(Resources.shield,20 + s.xPos , 20 + s.yPos , null);
                
                } 
                if(s instanceof TimeTravel){ 
                g.drawImage(Resources.time,20 + s.xPos , 20 + s.yPos , null);
                
                } 
        }
    }
    public void drawSpellEffect(Graphics g){
        
        
        
    }

    public void drawPieces(Graphics g) {
        for (Piece p : board.pieces) {
            if (p instanceof Rook) {
                switch (p.color) {
                    case White -> g.drawImage(Resources.whiteRook, p.xPos, p.yPos, null);
                    case Black -> g.drawImage(Resources.blackRook, p.xPos, p.yPos, null);
                }
            }
            if (p instanceof Bishop) {
                switch (p.color) {
                    case White -> g.drawImage(Resources.whiteBishop, p.xPos, p.yPos, null);
                    case Black -> g.drawImage(Resources.blackBishop, p.xPos, p.yPos, null);
                }
            }
            if (p instanceof Knight) {
                switch (p.color) {
                    case White -> g.drawImage(Resources.whiteKnight, p.xPos, p.yPos, null);
                    case Black -> g.drawImage(Resources.blackKnight, p.xPos, p.yPos, null);
                }
            }
            if (p instanceof Queen) {
                switch (p.color) {
                    case White -> g.drawImage(Resources.whiteQueen, p.xPos, p.yPos, null);
                    case Black -> g.drawImage(Resources.blackQueen, p.xPos, p.yPos, null);
                }
            }
            if (p instanceof King) {
                switch (p.color) {
                    case White -> g.drawImage(Resources.whiteKing, p.xPos, p.yPos, null);
                    case Black -> g.drawImage(Resources.blackKing, p.xPos, p.yPos, null);
                }
            }
            if (p instanceof Pawn) {
                switch (p.color) {
                    case White -> g.drawImage(Resources.whitePawn, p.xPos, p.yPos, null);
                    case Black -> g.drawImage(Resources.blackPawn, p.xPos, p.yPos, null);
                }
            }
        }
    }
}
