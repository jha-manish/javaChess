package com.chess.player;

import com.chess.board.Board;
import com.chess.board.Move;

public class MoveTransition {

    private final Board transitionBoard;
    private final Move move;
    private final MoveStatus moveStatus;

    public MoveTransition(final Board transitionBoard,
                          final Move move,
                          final MoveStatus moveStatus){
        this.transitionBoard=transitionBoard;
        this.move=move;
        this.moveStatus=moveStatus;
    }

    public MoveStatus getMoveStatus() {
        return this.moveStatus;
    }
}
