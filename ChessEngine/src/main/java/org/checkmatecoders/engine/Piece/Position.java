package org.checkmatecoders.engine.Piece;

public class Position{
    int x;
    int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void changePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object object){
        if(!(object instanceof Position)){
            return false;
        }
        Position temp= (Position) object;
        return temp.x == this.x && temp.y == this.y;
    }
}
