package org.checkmatecoders.frontend;

import org.checkmatecoders.engine.Piece.Color;
import org.checkmatecoders.engine.Piece.Piece;
import org.checkmatecoders.engine.Board;
import org.checkmatecoders.engine.Piece.Position;
import org.checkmatecoders.engine.Spell.Spell;
import org.checkmatecoders.engine.Spell.Swap;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class ChessListener implements MouseListener, MouseMotionListener {
    Board board;
    BoardPanel boardPanel;
    public ChessListener(Board board,BoardPanel boardPanel){
        this.board = board;
        this.boardPanel = boardPanel;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int col = e.getX() / Resources.SQUARE_SIZE;
        int row = e.getY() / Resources.SQUARE_SIZE;

        Piece pieceTry = board.getPiece(new Position(col,row));
        if(pieceTry != null && pieceTry.color == boardPanel.turn){
            boardPanel.chosenPiece = pieceTry;
        }
        Spell spellTry = board.getSpell(new Position(col, row));
        if(spellTry != null){
            boardPanel.choosenSpell = spellTry;
            System.out.println("I was chosen");
        }
        
        if (boardPanel.choosenSpell instanceof Swap) {
            
            
            if (((Swap) boardPanel.choosenSpell).getChoosenPosition() == null) {
                int col1 = e.getX() / Resources.SQUARE_SIZE;
                int row1 = e.getY() / Resources.SQUARE_SIZE;
    
                Position firstPosition = new Position(col1, row1);
                if (boardPanel.choosenSpell.board.getPiece(firstPosition) != null) {
                    System.out.println("First piece chosen: " + firstPosition);
                    ((Swap) boardPanel.choosenSpell).setChoosenPosition(firstPosition);
                }
            } else {
                int col2 = e.getX() / Resources.SQUARE_SIZE;
                int row2 = e.getY() / Resources.SQUARE_SIZE;
    
                Position secondPosition = new Position(col2, row2);
                if (boardPanel.choosenSpell.board.getPiece(secondPosition) != null) {
                    System.out.println("Second piece chosen: " + secondPosition);
                    ((Swap) boardPanel.choosenSpell).setTargetedPosition(secondPosition); 
                    boardPanel.choosenSpell.spellAction(); // Perform the spell action after both pieces are chosen
                    boardPanel.repaint();
                    ((Swap) boardPanel.choosenSpell).setTargetedPosition(null); // Reset targeted position for next use
                    ((Swap) boardPanel.choosenSpell).setChoosenPosition(null);
                    
                    if(boardPanel.turn == Color.White){
                        boardPanel.turn = Color.Black;
                        boardPanel.turn = Color.White;
                        boardPanel.turn = Color.Black;
                    }
                    else{
                        boardPanel.turn = Color.White;
                        boardPanel.turn = Color.Black;
                        boardPanel.turn = Color.White;
                    }
                    boardPanel.choosenSpell = null;

                }
            }
        }
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        if(boardPanel.chosenPiece != null){
            boardPanel.chosenPiece.xPos = e.getX() - Resources.SQUARE_SIZE / 2;
            boardPanel.chosenPiece.yPos = e.getY() - Resources.SQUARE_SIZE / 2;
        }

    }
    @Override
    public void mouseReleased(MouseEvent e) {
        int col = e.getX() / Resources.SQUARE_SIZE;
        int row = e.getY() / Resources.SQUARE_SIZE;
        Position newPosition = new Position(col,row);
        if(boardPanel.chosenPiece != null){
            List<Position> moves = boardPanel.chosenPiece.getValidMoves();
            Position currentPosition = boardPanel.chosenPiece.position;
            for(Position pos: moves){
                if(pos.equals(newPosition)){
                    board.movePiece(currentPosition,newPosition);
                    if(boardPanel.turn == Color.White){
                        boardPanel.turn = Color.Black;
                    }
                    else{
                        boardPanel.turn = Color.White;
                    }
                }
            }
            boardPanel.chosenPiece.xPos = boardPanel.chosenPiece.position.x * Resources.SQUARE_SIZE;
            boardPanel.chosenPiece.yPos = boardPanel.chosenPiece.position.y * Resources.SQUARE_SIZE;
            boardPanel.chosenPiece = null;
            boardPanel.repaint();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
}
