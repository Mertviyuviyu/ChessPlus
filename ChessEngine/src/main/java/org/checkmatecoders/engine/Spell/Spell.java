package org.checkmatecoders.engine.Spell;

import org.checkmatecoders.engine.Board;
import org.checkmatecoders.engine.Piece.Piece;
import org.checkmatecoders.engine.Piece.Position;

public abstract class Spell {
    public Piece piece;
    public Position position;
    public Board board;
    int cooldown;
    int duration;
    int amount;
    boolean currentlyUsed;
    private Position targetedPosition;

    public int xPos,yPos;

 public Spell(Board board,int amount, int cooldown, Position position){
    this.board = board;
    this.amount = amount;
    this.cooldown = cooldown;
    this.position = position;
    duration = 3;

    currentlyUsed = false;
    xPos = position.x * 70;
    yPos = position.y * 70;

    

    }

public int getAmount(){ return this.amount; }

public int getCooldown(){ return this.cooldown; }

public void decrementAmount(){
    this.amount--;
}

public abstract boolean checkValidity();

public abstract void spellAction();

public int getDuration() {
    return duration;
}

public void decrementDuration() {
    duration--;
}

public Position getTargetedPosition(){
    return targetedPosition;
}
public void setTargetedPosition(Position tposition){
    targetedPosition = tposition;
}
}

