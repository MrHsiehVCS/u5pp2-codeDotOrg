package u5pp;

public class King extends ChessPiece {
    public King(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }

    @Override
    public String toString() {
        return getIsWhite() ? "K" : "k";
    }
}
