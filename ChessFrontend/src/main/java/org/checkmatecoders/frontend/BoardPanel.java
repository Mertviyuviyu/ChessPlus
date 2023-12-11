package org.checkmatecoders.frontend;

import javax.swing.*;
import java.awt.*;
import org.checkmatecoders.engine.Board;
import org.checkmatecoders.engine.Piece.*;

public class BoardPanel extends JPanel {

    public final int cols = 8;
    public final int rows = 8;

    public Board board;

    public BoardPanel(){
        setPreferredSize(new Dimension(cols* Resources.SQUARE_SIZE,rows* Resources.SQUARE_SIZE));
        board = new Board();
        board.resetToStart();
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

        drawPieces(g);
    }

    public void drawPieces(Graphics g) {
        for (Piece p : board.pieces) {
            if (p instanceof Rook) {
                switch (p.color) {
                    case White -> g.drawImage(Resources.whiteRook, p.position.x* Resources.SQUARE_SIZE, p.position.y* Resources.SQUARE_SIZE, null);
                    case Black -> g.drawImage(Resources.blackRook, p.position.x* Resources.SQUARE_SIZE, p.position.y* Resources.SQUARE_SIZE, null);
                }
            }
            if (p instanceof Bishop) {
                switch (p.color) {
                    case White -> g.drawImage(Resources.whiteBishop, p.position.x* Resources.SQUARE_SIZE, p.position.y* Resources.SQUARE_SIZE, null);
                    case Black -> g.drawImage(Resources.blackBishop, p.position.x* Resources.SQUARE_SIZE, p.position.y* Resources.SQUARE_SIZE, null);
                }
            }
            if (p instanceof Knight) {
                switch (p.color) {
                    case White -> g.drawImage(Resources.whiteKnight, p.position.x* Resources.SQUARE_SIZE, p.position.y* Resources.SQUARE_SIZE, null);
                    case Black -> g.drawImage(Resources.blackKnight, p.position.x* Resources.SQUARE_SIZE, p.position.y* Resources.SQUARE_SIZE, null);
                }
            }
            if (p instanceof Queen) {
                switch (p.color) {
                    case White -> g.drawImage(Resources.whiteQueen, p.position.x* Resources.SQUARE_SIZE, p.position.y* Resources.SQUARE_SIZE, null);
                    case Black -> g.drawImage(Resources.blackQueen, p.position.x* Resources.SQUARE_SIZE, p.position.y* Resources.SQUARE_SIZE, null);
                }
            }
        }
    }
}
