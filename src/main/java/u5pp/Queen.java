package u5pp;

public class Queen extends ChessPiece {
    public Queen (ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }

    @Override
    public String toString() {
        return getIsWhite() ? "Q" : "q";
    }
}
