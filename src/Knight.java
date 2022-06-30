/**
 * This class represents a Knight.
 * A Knight has its position as a row and column,
 * and a color as an enum Color with values BLACK or WHITE.
 */

public class Knight extends ChessPieceImplementation {
    private int row, column;
    private TypeOfColor color;
    
    /**
     * Constructs a Knight and initializes
     * its initial position as a row and column, and a
     * color as an enum Color with values BLACK and WHITE.
     * @param column the column of this piece
     * @param row the row of this piece
     * @param color the color of this piece
     */
    public Knight(int column, int row, TypeOfColor color) {
        super(column, row, color);
    }

    /**
     *  Determine if this Knight can move to a given cell.
     *  Return true if it can move there, false otherwise.
     *  The piece cannot move to the current position, or go
     *  outside the chessboard.
     *  A knight can move only in an L pattern: two cells
     *  horizontally and one vertically or vice versa.
     * @return true if this chess piece can move to a given cell, false otherwise
     */
    @Override
    public boolean canMove(int col, int row) {
        if (!super.canMove(col, row)) return false;
        boolean situation1 = (Math.abs(row - this.getRow()) == 1) && (Math.abs(col - this.getColumn()) == 2);
        boolean situation2 = (Math.abs(row - this.getRow()) == 2) && (Math.abs(col - this.getColumn()) == 1);
        return (situation1 || situation2);
    }

    /**
     * Determine if this chess piece can kill a provided piece starting
     * from where it currently is. Return true if it can kill the provided
     * piece, false otherwise.
     * A Knight can kill any opponent’s piece if it can move to its place.
     * @return true if this chess piece can kill the provided piece,
     * false otherwise
     */
    public boolean canKill(ChessPiece piece) {
        return super.canKill(piece);
    }
}
