package u5pp;

public class Bishop extends ChessPiece {
    public Bishop(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }

    @Override 
    public boolean canMoveTo(int r, int c) {
        if(!super.canMoveTo(r, c)) {
            return false;
        }

        int rDiff = Math.abs(r - getRow());
        int cDiff = Math.abs(c - getColumn());

        // must be diagonal
        if (rDiff != cDiff) {
            return false;
        }

        // must not go through another piece
        int rMin = Math.min(r, getRow());
        int cMin = Math.min(c, getColumn());
        for(int i = 1; i < rDiff; i++) {
            if(getBoard()[rMin + i][cMin + i] != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return getIsWhite() ? "B" : "b";
    }
}
