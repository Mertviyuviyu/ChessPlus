package org.checkmatecoders.engine.Spell;

import org.checkmatecoders.engine.Board;
import org.checkmatecoders.engine.Piece.Piece;
import org.checkmatecoders.engine.Piece.Position;

public abstract class Spell {
    Piece piece;
    Position position;
    Board board;
    int cooldown;
    int amount;
    boolean currentlyUsed;

 public Spell(Board board,int amount, int cooldown){
    this.board = board;
    this.amount = amount;
    this.cooldown = cooldown;


    }

public int getAmount(){ return this.amount; }

public int getCooldown(){ return this.cooldown; }


public abstract boolean checkValidity();

public abstract void spellAction();
}
