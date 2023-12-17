package org.checkmatecoders.engine;

import org.checkmatecoders.engine.Piece.*;
import org.checkmatecoders.engine.Spell.Freeze;
import org.checkmatecoders.engine.Spell.Shield;
import org.checkmatecoders.engine.Spell.Spell;
import org.checkmatecoders.engine.Spell.Swap;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class Board {
    public List<Piece> pieces;
    public List<Spell> spells;
    public List<Runnable> listeners;


    public Board(){
        pieces = new ArrayList<>();
        listeners = new ArrayList<>();
    }

    public void addPiece(Piece p) {
        pieces.add(p);
        listeners.forEach(i -> i.run());
    }

    public void addSpell(Spell s) {
        spells.add(s);
        listeners.forEach(i -> i.run());
    }

    public void resetToStart() {
        pieces = new ArrayList<>();
        addPiece(new Rook(Color.White, this, new Position(0, 7)));
        addPiece(new Knight(Color.White,this,new Position(1,7)));
        addPiece(new Bishop(Color.White,this,new Position(2,7)));
        addPiece(new Queen(Color.White,this,new Position(3,7)));
        addPiece(new King(Color.White,this,new Position(4,7)));
        addPiece(new Rook(Color.White, this, new Position(7, 7)));
        addPiece(new Knight(Color.White,this,new Position(6,7)));
        addPiece(new Bishop(Color.White,this,new Position(5,7)));
        addPiece(new Rook(Color.Black, this, new Position(0, 0)));
        addPiece(new Knight(Color.Black,this,new Position(1,0)));
        addPiece(new Bishop(Color.Black,this,new Position(2,0)));
        addPiece(new Queen(Color.Black,this,new Position(3,0)));
        addPiece(new King(Color.Black,this,new Position(4,0)));
        addPiece(new Rook(Color.Black, this, new Position(7, 0)));
        addPiece(new Knight(Color.Black,this,new Position(6,0)));
        addPiece(new Bishop(Color.Black,this,new Position(5,0)));

        addPiece(new Pawn(Color.White,this,new Position(0,6)));
        addPiece(new Pawn(Color.White,this,new Position(1,6)));
        addPiece(new Pawn(Color.White,this,new Position(2,6)));
        addPiece(new Pawn(Color.White,this,new Position(3,6)));
        addPiece(new Pawn(Color.White,this,new Position(4,6)));
        addPiece(new Pawn(Color.White,this,new Position(5,6)));
        addPiece(new Pawn(Color.White,this,new Position(6,6)));
        addPiece(new Pawn(Color.White,this,new Position(7,6)));

        addPiece(new Pawn(Color.Black,this,new Position(0,1)));
        addPiece(new Pawn(Color.Black,this,new Position(1,1)));
        addPiece(new Pawn(Color.Black,this,new Position(2,1)));
        addPiece(new Pawn(Color.Black,this,new Position(3,1)));
        addPiece(new Pawn(Color.Black,this,new Position(4,1)));
        addPiece(new Pawn(Color.Black,this,new Position(5,1)));
        addPiece(new Pawn(Color.Black,this,new Position(6,1)));
        addPiece(new Pawn(Color.Black,this,new Position(7,1)));
        

        spells = new ArrayList<>();
        addSpell(new Swap(this, 2, 2, new Position(0, 8)));
        addSpell(new Freeze(this, 2, 2,3, new Position(1, 8)));
        addSpell(new Shield(this, 2, 2, new Position(2, 8)));
        listeners.forEach(i -> i.run());
    }
    public int spellSize() { return spells.size();}
    
    public Piece getPiece(Position position) {
        for (Piece i: pieces) {
            if (i.position.equals(position)) {
                return i;
            }
        }
        return null;
    }

    public Spell getSpell(Position position) {
        for (Spell i: spells) {
            if (i.position.equals(position)) {
                return i;
            }
        }
        return null;
    }
    
    public void movePiece(Position p1, Position p2){
        if(getPiece(p2) != null){
            pieces.remove(getPiece(p2));
        }
        getPiece(p1).move(p2);
        listeners.forEach(i -> i.run());
    }
    public void register(Runnable listener){
        listeners.add(listener);
    }
}
