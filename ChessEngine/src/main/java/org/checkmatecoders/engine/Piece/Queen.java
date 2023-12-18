package org.checkmatecoders.engine.Piece;

import org.checkmatecoders.engine.Board;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{

    public Queen(Color color, Board board, Position position) {
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
            else if (oppKing.y==position.y) {
                for(int i = 1; i<oppKing.x-position.x;i++){
                    checkDir.add(new Position((oppKing.x - i),(oppKing.y)));
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
            else if (oppKing.y==position.y) {
                for(int i = 1; i<position.x-oppKing.x;i++){
                    checkDir.add(new Position((oppKing.x + i),(oppKing.y)));
                }
            }
        }
        else if (oppKing != null && oppKing.x==position.x) {
            if(oppKing.y>position.y){
                for(int i = 1; i<oppKing.y-position.y;i++){
                    checkDir.add(new Position((oppKing.x),(oppKing.y -i)));
                }
            }
            else if (oppKing.y<position.y) {
                for(int i = 1; i<position.y-oppKing.y;i++){
                    checkDir.add(new Position((oppKing.x),(oppKing.y +i)));
                }
            }
        }
        return  checkDir;
    }

    @Override
    public List<Position> getValidMoves() {
        List<Position> allMoves = new ArrayList<Position>();
        List<Position> allNewMoves = new ArrayList<Position>();
        //Move Right
        if(canMove && capturable){
        for(int x = this.position.x + 1 ; x < 8 ; x++){
            Position pos = new Position(x, this.position.y);
            if(isInBounds(pos)){
                if(board.isTherePiece(pos)){
                    if(board.getPiece(pos).color != this.color){
                        if(board.getPiece(pos).capturable){
                            allMoves.add(pos);
                            }else{
                                break;
                            }
                    }
                    break;
                }
                allMoves.add(pos);
            }
        }
        //Move Left
        for(int x = this.position.x - 1 ; x >= 0 ; x--){
            Position pos = new Position(x, this.position.y);
            if(isInBounds(pos)){
                if(board.isTherePiece(pos)){
                    if(board.getPiece(pos).color != this.color){
                        if(board.getPiece(pos).capturable){
                            allMoves.add(pos);
                            }else{
                                break;
                            }
                    }
                    break;
                }
                allMoves.add(pos);
            }
        }
        //Move Down
        for(int y = this.position.y - 1 ; y >= 0 ; y--){
            Position pos = new Position(this.position.x, y);
            if(isInBounds(pos)){
                if(board.isTherePiece(pos)){
                    if(board.getPiece(pos).color != this.color){
                        if(board.getPiece(pos).capturable){
                            allMoves.add(pos);
                            }else{
                                break;
                            }
                    }
                    break;
                }
                allMoves.add(pos);
            }
        }
        //Move Up
        for(int y = this.position.y + 1 ; y < 8 ; y++){
            Position pos = new Position(this.position.x, y);
            if(isInBounds(pos)){
                if(board.isTherePiece(pos)){
                    if(board.getPiece(pos).color != this.color){
                        if(board.getPiece(pos).capturable){
                            allMoves.add(pos);
                            }else{
                                break;
                            }
                    }
                    break;
                }
                allMoves.add(pos);
            }
        }
        //Up right
        for(int i = 1; this.position.x + i < 8 && this.position.y + i < 8; i++){
            Position pos = new Position(this.position.x + i, this.position.y + i);
            if(isInBounds(pos)){
                if(board.isTherePiece(pos)){
                    if(board.getPiece(pos).color != this.color){
                        if(board.getPiece(pos).capturable){
                            allMoves.add(pos);
                            }else{
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
                        if(board.getPiece(pos).capturable){
                            allMoves.add(pos);
                            }else{
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
                        if(board.getPiece(pos).capturable){
                        allMoves.add(pos);
                        }else{
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
                        if(board.getPiece(pos).capturable){
                        allMoves.add(pos);
                        }else{
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
    @Override
    public List<Position> getValidMoves2() {
        List<Position> allMoves = new ArrayList<Position>();
        //Move Right
        if(canMove && capturable){
            for(int x = this.position.x + 1 ; x < 8 ; x++){
                Position pos = new Position(x, this.position.y);
                if(isInBounds(pos)){
                    if(board.isTherePiece(pos)){
                        if(board.getPiece(pos).color != this.color){
                            allMoves.add(pos);
                        }
                        break;
                    }
                    allMoves.add(pos);
                }
            }
            //Move Left
            for(int x = this.position.x - 1 ; x >= 0 ; x--){
                Position pos = new Position(x, this.position.y);
                if(isInBounds(pos)){
                    if(board.isTherePiece(pos)){
                        if(board.getPiece(pos).color != this.color){
                            allMoves.add(pos);
                        }
                        break;
                    }
                    allMoves.add(pos);
                }
            }
            //Move Down
            for(int y = this.position.y - 1 ; y >= 0 ; y--){
                Position pos = new Position(this.position.x, y);
                if(isInBounds(pos)){
                    if(board.isTherePiece(pos)){
                        if(board.getPiece(pos).color != this.color){
                            allMoves.add(pos);
                        }
                        break;
                    }
                    allMoves.add(pos);
                }
            }
            //Move Up
            for(int y = this.position.y + 1 ; y < 8 ; y++){
                Position pos = new Position(this.position.x, y);
                if(isInBounds(pos)){
                    if(board.isTherePiece(pos)){
                        if(board.getPiece(pos).color != this.color){
                            allMoves.add(pos);
                        }
                        break;
                    }
                    allMoves.add(pos);
                }
            }
            //Up right
            for(int i = 1; this.position.x + i < 8 && this.position.y + i < 8; i++){
                Position pos = new Position(this.position.x + i, this.position.y + i);
                if(isInBounds(pos)){
                    if(board.isTherePiece(pos)){
                        if(board.getPiece(pos).color != this.color){
                            allMoves.add(pos);
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
                            allMoves.add(pos);
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
                            allMoves.add(pos);
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
                            allMoves.add(pos);
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
