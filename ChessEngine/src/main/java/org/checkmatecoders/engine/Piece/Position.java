package org.checkmatecoders.engine.Piece;

public class Position{
    public int x;
    public int y;
    boolean capturable;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
        capturable = true;
    }

    public void changePosition(Position p) {
        this.x = p.x;
        this.y = p.y;
    }

    public boolean equals(Object object){
        if(!(object instanceof Position)){
            return false;
        }
        Position temp= (Position) object;
        return temp.x == this.x && temp.y == this.y;
    }

    public String toString(){
        return x + ","+ y;
    }
}
