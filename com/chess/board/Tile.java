package com.chess.board;

import com.chess.pieces.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

    protected final int tileCoordiante;

    private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createPossibleEmptyTiles();

    private static Map<Integer,EmptyTile> createPossibleEmptyTiles() {

            final Map<Integer, EmptyTile> emptyTileMap= new HashMap<>();

            for (int i=0; i<BoardUtils.NUM_TILES; i++){
                emptyTileMap.put(i, new EmptyTile(i));
            }

            return ImmutableMap.copyOf(emptyTileMap);
    }


    Tile(final int tileCoordiante){
        this.tileCoordiante= tileCoordiante;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

    public static Tile createTile(final int tileCoordiante, final Piece piece) {

        return piece != null? new OccupiedTile(tileCoordiante, piece) : EMPTY_TILES_CACHE.get(tileCoordiante);
    }

    public static final class EmptyTile extends Tile {

       private EmptyTile(final int coordinate){
            super(coordinate);
        }

        @Override
        public String toString(){
           return "-";
        }

        @Override
        public boolean isTileOccupied(){
            return false;
        }

        @Override
        public Piece getPiece(){
            return null;

        }

        public static Tile createTile(final int tileCoordinate, final Piece piece){
           return piece!=null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
        }

    }

    public static final class OccupiedTile extends Tile {

        private final Piece pieceOnTile;

        private OccupiedTile(int tileCoordinate, Piece pieceOnTile){
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

        @Override
        public String toString(){
            return getPiece().getPieceAlliance().isBlack() ? getPiece().toString().toLowerCase() : getPiece().toString();
        }
    }

}
