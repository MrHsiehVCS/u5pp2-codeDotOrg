package u5pp;

public class Pawn extends ChessPiece {
    public Pawn(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }

    @Override
    public String toString() {
        return getIsWhite() ? "P" : "p";
    }
}
