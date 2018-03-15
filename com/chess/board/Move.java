package com.chess.board;

import com.chess.pieces.Piece;

public abstract class Move {


    final Board board;
    final Piece movedpiece;
    final int destinationCoordinate;

    private Move(final Board board, final Piece movedPiece, final int destinationCoordinate){
        this.board = board;
        this.movedpiece = movedPiece;
        this.destinationCoordinate = destinationCoordinate;
    }

    public int getDestinationCoordinates() {
        return this.destinationCoordinate;
    }

    public abstract Board execute();

    public static final class MajorMove extends Move{

        public MajorMove(final Board board, final Piece movedpiece, final int destinatioonCoordinate) {
            super(board, movedpiece, destinatioonCoordinate);
        }

        @Override
        public Board execute(){
            return null;
        }
    }

    public static class AttackMove extends Move{

        final Piece attackedPiece;

        public AttackMove(final Board board, final Piece movedpiece, final int destinatioonCoordinate, final Piece attackedPiece) {
            super(board, movedpiece, destinatioonCoordinate);
            this.attackedPiece = attackedPiece;
        }

        @Override
        public Board execute(){
            return null;
        }
    }
}
