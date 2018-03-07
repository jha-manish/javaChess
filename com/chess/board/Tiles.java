package com.chess.board;

import com.chess.pieces.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public abstract class Tiles {

    protected final int tileCoordiante;

    private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createPossibleEmptyTiles();

    private static Map<Integer,EmptyTile> createPossibleEmptyTiles() {

            final Map<Integer, EmptyTile> emptyTileMap= new HashMap<>();

            for (int i=0; i<BoardUtils.NUM_TILES; i++){
                emptyTileMap.put(i, new EmptyTile(i));
            }

            return ImmutableMap.copyOf(emptyTileMap);
    }


    Tiles(final int tileCoordiante){
        this.tileCoordiante= tileCoordiante;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

    public static final class EmptyTile extends Tiles {

       private EmptyTile(final int coordinate){
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

        public static Tiles createTile(final int tileCoordinate, final Piece piece){
           return piece!=null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
        }

    }

    public static final class OccupiedTile extends Tiles{

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
    }

}
