package com.chess.board;

import com.chess.pieces.Piece;
import com.google.common.base.Joiner;

public abstract class Move {


    final Board board;
    final Piece movedpiece;
    final int destinationCoordinate;

    private Move(final Board board, final Piece movedpiece, final int destinatioonCoordinate){
        this.board = board;
        this.movedpiece = movedpiece;
        this.destinationCoordinate = destinatioonCoordinate;
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
