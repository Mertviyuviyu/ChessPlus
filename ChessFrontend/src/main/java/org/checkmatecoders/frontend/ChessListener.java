package org.checkmatecoders.frontend;

import org.checkmatecoders.engine.Piece.Color;
import org.checkmatecoders.engine.Piece.Piece;
import org.checkmatecoders.engine.Board;
import org.checkmatecoders.engine.Piece.Position;
import org.checkmatecoders.engine.Spell.Freeze;
import org.checkmatecoders.engine.Spell.Shield;
import org.checkmatecoders.engine.Spell.Spell;
import org.checkmatecoders.engine.Spell.Swap;
import org.checkmatecoders.engine.Spell.Teleport;
import org.checkmatecoders.engine.Spell.TimeTravel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


public class ChessListener implements MouseListener, MouseMotionListener {
    Board board;
    BoardPanel boardPanel;
    List<Spell> activeSpellEffects;
    public ChessListener(Board board,BoardPanel boardPanel){
        this.board = board;
        this.boardPanel = boardPanel;
         activeSpellEffects = new ArrayList<>();
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
            boardPanel.choosenSpell.setTargetedPosition(new Position(col, row));
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
                    
                    boardPanel.nextTurn();
                    boardPanel.choosenSpell = null;

                }
            }
        }
        if (boardPanel.choosenSpell instanceof Teleport){
            if (((Teleport) boardPanel.choosenSpell).getChoosenPosition() == null) {
                int col1 = e.getX() / Resources.SQUARE_SIZE;
                int row1 = e.getY() / Resources.SQUARE_SIZE;
    
                Position firstPosition = new Position(col1, row1);
                if (boardPanel.choosenSpell.board.getPiece(firstPosition) != null) {
                    System.out.println("The piece chosen: " + firstPosition);
                    ((Teleport) boardPanel.choosenSpell).setChoosenPosition(firstPosition);
                }

        }else {
                int col2 = e.getX() / Resources.SQUARE_SIZE;
                int row2 = e.getY() / Resources.SQUARE_SIZE;
    
                Position secondPosition = new Position(col2, row2);
                if (boardPanel.choosenSpell.board.getPiece(secondPosition) != null) {
                    System.out.println("Place chosen: " + secondPosition);
                    ((Teleport) boardPanel.choosenSpell).setTargetedPosition(secondPosition); 
                    boardPanel.choosenSpell.spellAction(); // Perform the spell action after both pieces are chosen
                    
                    boardPanel.choosenSpell.setTargetedPosition(null); // Reset targeted position for next use
                    ((Teleport) boardPanel.choosenSpell).setChoosenPosition(null);
                    
                    boardPanel.nextTurn();
                    boardPanel.choosenSpell = null;
                    boardPanel.repaint();

                }
            }
    }
    if(boardPanel.choosenSpell instanceof TimeTravel){
        System.out.println("ZA WARUDOO!");

    }
}
    @Override
    public void mouseDragged(MouseEvent e) {
        if(boardPanel.chosenPiece != null){
            boardPanel.chosenPiece.xPos = e.getX() - Resources.SQUARE_SIZE / 2;
            boardPanel.chosenPiece.yPos = e.getY() - Resources.SQUARE_SIZE / 2;
        }
        if(boardPanel.choosenSpell != null){
        if(boardPanel.choosenSpell instanceof Freeze){
            boardPanel.choosenSpell.xPos = e.getX() - Resources.SQUARE_SIZE / 2;
            boardPanel.choosenSpell.yPos = e.getY() - Resources.SQUARE_SIZE / 2;
            boardPanel.choosenSpell.position = new Position(e.getX() / Resources.SQUARE_SIZE,e.getY() / Resources.SQUARE_SIZE);
            boardPanel.choosenSpell.setTargetedPosition(new Position(boardPanel.choosenSpell.xPos,boardPanel.choosenSpell.yPos));
            boardPanel.repaint();
        }
        if(boardPanel.choosenSpell instanceof Shield){
            boardPanel.choosenSpell.xPos = e.getX() - Resources.SQUARE_SIZE / 2;
            boardPanel.choosenSpell.yPos = e.getY() - Resources.SQUARE_SIZE / 2;
            boardPanel.choosenSpell.setTargetedPosition(new Position(boardPanel.choosenSpell.xPos,boardPanel.choosenSpell.yPos));
            boardPanel.repaint();
        }
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
                    if(boardPanel.choosenSpell instanceof TimeTravel){
                        ((TimeTravel) boardPanel.choosenSpell).setTimePiece(currentPosition);
                        boardPanel.choosenSpell.setTargetedPosition(newPosition);
                        boardPanel.choosenSpell.spellAction();
                        boardPanel.choosenSpell = null;
                    boardPanel.repaint();
                        break;
                    }
                    board.movePiece(currentPosition,newPosition);
                    boardPanel.nextTurn();
                }
            }
            boardPanel.chosenPiece.xPos = boardPanel.chosenPiece.position.x * Resources.SQUARE_SIZE;
            boardPanel.chosenPiece.yPos = boardPanel.chosenPiece.position.y * Resources.SQUARE_SIZE;
            boardPanel.chosenPiece = null;
            boardPanel.repaint();
        }
        if(boardPanel.choosenSpell != null){
            if( boardPanel.choosenSpell instanceof Freeze){
                Freeze tempFreeze = new Freeze(board, 3, 3, 3, boardPanel.choosenSpell.position);
                Position tempPosition = new Position(newPosition.x, newPosition.y);
                tempFreeze.setTargetedPosition(tempPosition);
                activeSpellEffects.add(tempFreeze);
                
                boardPanel.choosenSpell.setTargetedPosition(newPosition);
                
                boardPanel.choosenSpell.spellAction();
                
                    
                boardPanel.nextTurn();
                boardPanel.choosenSpell.position = new Position(1, 8);
                boardPanel.choosenSpell.xPos = boardPanel.choosenSpell.position.x * Resources.SQUARE_SIZE;
                boardPanel.choosenSpell.yPos = boardPanel.choosenSpell.position.y * Resources.SQUARE_SIZE;
                boardPanel.choosenSpell = null;
                boardPanel.repaint();   
                }
                   
                if( boardPanel.choosenSpell instanceof Shield){
                Shield temp =new Shield(board, 3, 3, boardPanel.choosenSpell.position);
                Position tempPosition = new Position(newPosition.x, newPosition.y);
                temp.setTargetedPosition(tempPosition);
                activeSpellEffects.add(temp);
                boardPanel.choosenSpell.setTargetedPosition(newPosition);
                boardPanel.choosenSpell.spellAction();
                System.out.println(" I am protected");
                boardPanel.nextTurn();
                boardPanel.choosenSpell.xPos = boardPanel.choosenSpell.position.x * Resources.SQUARE_SIZE;
                boardPanel.choosenSpell.yPos = boardPanel.choosenSpell.position.y * Resources.SQUARE_SIZE;
                boardPanel.choosenSpell = null;
                    
                boardPanel.repaint();
            }
                }
                

            }
            
            
        

    

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
}
