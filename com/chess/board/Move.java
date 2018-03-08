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

    public static final class MajorMove extends Move{

        public MajorMove(final Board board, final Piece movedpiece, final int destinatioonCoordinate) {
            super(board, movedpiece, destinatioonCoordinate);
        }
    }

    public static class AttackMove extends Move{

        final Piece attackedPiece;

        public AttackMove(final Board board, final Piece movedpiece, final int destinatioonCoordinate, final Piece attackedPiece) {
            super(board, movedpiece, destinatioonCoordinate);
            this.attackedPiece = attackedPiece;
        }
    }
}
