package com.chess.pieces;

import com.chess.Alliance;
import com.chess.board.Board;
import com.chess.board.BoardUtils;
import com.chess.board.Move;
import com.chess.board.Tile;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Rook extends Piece {
    public Rook(Alliance pieceAlliance, final int piecePosition) {
        super(PieceType.ROOK, piecePosition, pieceAlliance);
    }
    private final static int[] CANDIDATE_MOVE_VECTOR_COORDINATES = {-8, -1, 1, 8};

    @Override
    public Collection<Move> calculateLegalMoves(final Board board) {

        final List<Move> legalMoves = new ArrayList<>();

        for(final int candidateCoordinateOffset: CANDIDATE_MOVE_VECTOR_COORDINATES){

            int candidateDestintationCoordinate = this.piecePosition;

            while(BoardUtils.isValidTileCoordinate(candidateDestintationCoordinate)) {
                if (isFirstColumnExclusion(candidateDestintationCoordinate, candidateCoordinateOffset) ||
                        isEighthColumnExclusion(candidateDestintationCoordinate, candidateCoordinateOffset))
                    break;
            }

            while(BoardUtils.isValidTileCoordinate(candidateDestintationCoordinate)){
                candidateDestintationCoordinate += candidateCoordinateOffset;

                if(BoardUtils.isValidTileCoordinate(candidateDestintationCoordinate)){
                    final Tile candidateDestinationTile = board.getTile(candidateDestintationCoordinate);

                    if (!candidateDestinationTile.isTileOccupied()){
                        legalMoves.add(new Move.MajorMove(board, this, candidateDestintationCoordinate));
                    } else {

                        final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                        final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();

                        if (this.pieceAlliance != pieceAlliance) {
                            legalMoves.add(new Move.AttackMove(board, this, candidateDestintationCoordinate, pieceAtDestination));
                        }
                        break;
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }

    @Override
    public String toString(){

        return Piece.PieceType.ROOK.toString();
    }
    private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset){
        return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == -1);
    }

    private static boolean isEighthColumnExclusion(final int currentPosition, final int candidateOffset){
        return BoardUtils.EIGHTH_COLUMN[currentPosition] && (candidateOffset == 1);
    }
}
