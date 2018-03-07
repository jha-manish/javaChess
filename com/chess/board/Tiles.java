package com.chess.board;

import com.chess.pieces.Piece;

import java.util.Map;

public abstract class Tiles {

    protected final int tileCoordiante;

    private static final Map<Integer, EmptyTile> EMPTY_TILES = createPossibleEmptyTiles();

    private static
    Tiles(int tileCoordiante){
        this.tileCoordiante= tileCoordiante;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

    public static final class EmptyTile extends Tiles {

        EmptyTile(final int coordinate){
            super(coordinate);
        }

        @Override
        public boolean isTileOccupied(){
            return false;
        }

        @Override
        public Piece getPiece(){
            return null;

        }

    }

    public static final class OccupiedTile extends Tiles{

        private final Piece pieceOnTile;

        OccupiedTile(int tileCoordinate, Piece pieceOnTile){
            super(tileCoordinate);
            this.pieceOnTile=pieceOnTile;
        }

        @Override
        public boolean isTileOccupied(){
            return true;
        }

        @Override
        public Piece getPiece(){
            return this.pieceOnTile;
        }
    }

}
