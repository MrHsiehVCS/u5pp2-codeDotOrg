package u5pp;

public class Rook extends ChessPiece {
    public Rook(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }

    @Override
    public String toString() {
        return getIsWhite() ? "R" : "r";
    }
}
