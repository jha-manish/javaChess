public abstract class Tiles {
    int tileCoordiante;

    Tiles(int tileCoordiante){
        this.tileCoordiante= tileCoordiante;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

    public static final class EmptyTile extends Tiles {

        EmptyTile(int coordinate){
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

        Piece pieceOnTile;

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
