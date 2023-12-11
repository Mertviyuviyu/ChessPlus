package org.checkmatecoders.engine.Piece;

import org.checkmatecoders.engine.Board;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{
    public Knight(Color color, Board board) {
        super(color, board);

    }

    @Override
    public List<Position> getValidMoves() {
        List<Position> allMoves = new ArrayList<Position>();
        allMoves.add(new Position(this.position.x + 2, this.position.y + 1));
        allMoves.add(new Position(this.position.x + 1, this.position.y + 2));

        allMoves.add(new Position(this.position.x - 2, this.position.y + 1));
        allMoves.add(new Position(this.position.x - 1, this.position.y + 2));

        allMoves.add(new Position(this.position.x + 2, this.position.y - 1));
        allMoves.add(new Position(this.position.x + 1, this.position.y - 2));

        allMoves.add(new Position(this.position.x - 2, this.position.y - 1));
        allMoves.add(new Position(this.position.x - 1, this.position.y - 2));

        allMoves.removeIf(i -> i.x < 0 || i.x > 7 || i.y < 0 || i.y > 7);

        allMoves.removeIf(i -> {
            Piece temp = this.board.getPiece(i);
            if (temp == null)
                return false;
            if (temp.color != this.color)
                return false;
            return true;
        });

        return allMoves;
    }
}
