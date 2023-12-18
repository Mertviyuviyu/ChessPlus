package org.checkmatecoders.engine.Piece;

import org.checkmatecoders.engine.Board;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{

    public Bishop(Color color, Board board, Position position) {
        super(color, board, position);
    }

    @Override
    public List<Position> checkDirection() {
        Position oppKing = null;
        List<Position> checkDir = new ArrayList<Position>();
        for(Position p : getValidMoves2()){
            if(board.getPiece(p) instanceof King && board.getPiece(p).color != this.color){
                oppKing = p;
            }
        }
        if(oppKing != null && oppKing.x>position.x){
            if(oppKing.y>position.y){
                for(int i = 1; i<oppKing.x-position.x;i++){
                    checkDir.add(new Position((oppKing.x - i),(oppKing.y -i)));
                }
            }
            else if (oppKing.y<position.y) {
                for(int i = 1; i<oppKing.x-position.x;i++){
                    checkDir.add(new Position((oppKing.x - i),(oppKing.y +i)));
                }
            }
        }
        else if (oppKing != null && oppKing.x<position.x) {
            if(oppKing.y>position.y){
                for(int i = 1; i<position.x-oppKing.x;i++){
                    checkDir.add(new Position((oppKing.x + i),(oppKing.y -i)));
                }
            }
            else if (oppKing.y<position.y) {
                for(int i = 1; i<position.x-oppKing.x;i++){
                    checkDir.add(new Position((oppKing.x + i),(oppKing.y +i)));
                }
            }
        }
        return checkDir;
    }

    @Override
    public List<Position> getValidMoves() {
        List<Position> allMoves = new ArrayList<Position>();
        List<Position> allNewMoves = new ArrayList<Position>();
        //Up right
        if(canMove){
        for(int i = 1; this.position.x + i < 8 && this.position.y + i < 8; i++){
            Position pos = new Position(this.position.x + i, this.position.y + i);
            if(isInBounds(pos)){
                if(board.isTherePiece(pos)){
                    if(board.getPiece(pos).color != this.color){
                        if(board.getPiece(pos).capturable)
                        allMoves.add(pos);
                        else{
                            break;
                        }
                    }
                    break;
                }
                allMoves.add(pos);
            }
        }
        //Up left
        for(int i = 1; this.position.x - i >= 0 && this.position.y + i < 8; i++){
            Position pos = new Position(this.position.x - i, this.position.y + i);
            if(isInBounds(pos)){
                if(board.isTherePiece(pos)){
                    if(board.getPiece(pos).color != this.color){
                        if(board.getPiece(pos).capturable)
                        allMoves.add(pos);
                        else{
                            break;
                        }
                    }
                    break;
                }
                allMoves.add(pos);
            }
        }
        //Down right
        for (int i = 1; this.position.x + i < 8 && this.position.y - i >= 0; i++) {
            Position pos = new Position(this.position.x + i, this.position.y - i);
            if (isInBounds(pos)) {
                if (board.isTherePiece(pos)) {
                    if (board.getPiece(pos).color != this.color) {
                        if(board.getPiece(pos).capturable)
                        allMoves.add(pos);
                        else{
                            break;
                        }
                    }
                    break;
                }
                allMoves.add(pos);
            }
        }
        //Down left
        for (int i = 1; this.position.x - i >= 0 && this.position.y - i >= 0; i++) {
            Position pos = new Position(this.position.x - i, this.position.y - i);
            if (isInBounds(pos)) {
                if (board.isTherePiece(pos)) {
                    if (board.getPiece(pos).color != this.color) {
                        if(board.getPiece(pos).capturable)
                        allMoves.add(pos);
                        else{
                            break;
                        }
                    }
                    break;
                }
                allMoves.add(pos);
            }
        }
    }
        if(board.check().size()==0){
            return allMoves;

        }
        if(board.check().size()>1){
            return new ArrayList<Position>();
        }
        for(Position i : allMoves){
            if(i.equals(board.check().get(0)) || this.board.getPiece(board.check().get(0)).checkDirection().contains(i)){
                allNewMoves.add(i);
            }
        }
        return allNewMoves;

    }
    public List<Position> getValidMoves2(){
        List<Position> allMoves = new ArrayList<Position>();
        //Up right
        if(canMove){
            for(int i = 1; this.position.x + i < 8 && this.position.y + i < 8; i++){
                Position pos = new Position(this.position.x + i, this.position.y + i);
                if(isInBounds(pos)){
                    if(board.isTherePiece(pos)){
                        if(board.getPiece(pos).color != this.color){
                            if(board.getPiece(pos).capturable)
                                allMoves.add(pos);
                            else{
                                break;
                            }
                        }
                        break;
                    }
                    allMoves.add(pos);
                }
            }
            //Up left
            for(int i = 1; this.position.x - i >= 0 && this.position.y + i < 8; i++){
                Position pos = new Position(this.position.x - i, this.position.y + i);
                if(isInBounds(pos)){
                    if(board.isTherePiece(pos)){
                        if(board.getPiece(pos).color != this.color){
                            if(board.getPiece(pos).capturable)
                                allMoves.add(pos);
                            else{
                                break;
                            }
                        }
                        break;
                    }
                    allMoves.add(pos);
                }
            }
            //Down right
            for (int i = 1; this.position.x + i < 8 && this.position.y - i >= 0; i++) {
                Position pos = new Position(this.position.x + i, this.position.y - i);
                if (isInBounds(pos)) {
                    if (board.isTherePiece(pos)) {
                        if (board.getPiece(pos).color != this.color) {
                            if(board.getPiece(pos).capturable)
                                allMoves.add(pos);
                            else{
                                break;
                            }
                        }
                        break;
                    }
                    allMoves.add(pos);
                }
            }
            //Down left
            for (int i = 1; this.position.x - i >= 0 && this.position.y - i >= 0; i++) {
                Position pos = new Position(this.position.x - i, this.position.y - i);
                if (isInBounds(pos)) {
                    if (board.isTherePiece(pos)) {
                        if (board.getPiece(pos).color != this.color) {
                            if(board.getPiece(pos).capturable)
                                allMoves.add(pos);
                            else{
                                break;
                            }
                        }
                        break;
                    }
                    allMoves.add(pos);
                }
            }
        }
        return allMoves;
    }
}
