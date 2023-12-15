package org.checkmatecoders.frontend;

import org.checkmatecoders.engine.Piece.Color;
import org.checkmatecoders.engine.Piece.Piece;
import org.checkmatecoders.engine.Board;
import org.checkmatecoders.engine.Piece.Position;


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
