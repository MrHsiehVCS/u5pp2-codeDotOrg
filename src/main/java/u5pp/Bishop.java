package u5pp;

public class Bishop extends ChessPiece {
    public Bishop(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }

    @Override
    public String toString() {
        return getIsWhite() ? "B" : "b";
    }
}
