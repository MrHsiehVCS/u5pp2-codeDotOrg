package u5pp;

public class Knight extends ChessPiece {
    public Knight(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }

    @Override
    public String toString() {
        return getIsWhite() ? "N" : "n";
    }
}
