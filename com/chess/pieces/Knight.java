package com.chess.pieces;

import com.chess.Alliance;
import com.chess.board.Board;
import com.chess.board.Move;
import com.chess.board.Tiles;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    private static final int [] CANDIDATE_MOVE_COORDINATES={-17, -15, 10, -6, 6, 10, 15, 17};

    Knight(int piecePosition, Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public List<Move> calculateLegalMoves(Board board) {

        int candidateDestinateCoordinate;

        final List<Move> legalMoves= new ArrayList<>();

        for (final int currentCandidate: CANDIDATE_MOVE_COORDINATES){

            candidateDestinateCoordinate = this.piecePosition + currentCandidate;

            if(true){
                final Tiles candidateDestinationTile = board.getTile(candidateDestinateCoordinate);

                if (!candidateDestinationTile.isTileOccupied()){
                    legalMoves.add(new Move());
                } else {

                    final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                    final Alliance piececAlliance = pieceAtDestination.getPieceAlliance();

                    if (this.pieceAlliance != pieceAlliance){
                        legalMoves.add(new Move());
                    }
                }
            }

        }

        return ImmutableList.copyOf(legalMoves);
    }
}
