/**
 * This class represents a Queen.
 * A Queen has its position as a row and column,
 * and a color as an enum Color with values BLACK or WHITE.
 */
public class Queen extends ChessPieceImplementation {

    /**
     * Constructs a Queen and initializes
     * its initial position as a row and column, and a
     * color as an enum Color with values BLACK and WHITE.
     * @param row the row of this piece
     * @param column the column of this piece
     * @param color the color of this piece
     */
    public Queen(int column, int row, TypeOfColor color) {
        super(column, row, color);
    }

    /**
     *  Determine if this chess piece can move to a given cell.
     *  Return true if it can move there, false otherwise.
     *  A Queen can can move horizontally, vertically and diagonally.
     * @return true if this chess piece can move to a given cell, false otherwise
     */
    @Override
    public boolean canMove(int col, int row) {
        if (!super.canMove(col, row)) return false;
        return (Math.abs(row - this.getRow()) == Math.abs(col - this.getColumn()) ||
                row == this.getRow() || col == this.getColumn());
    }

    /**
     * Determine if this chess piece can kill a provided piece starting
     * from where it currently is. Return true if it can kill the provided
     * piece, false otherwise.
     * A Queen can kill any opponent’s piece if it can move to its place.
     * @return true if this chess piece can kill the provided piece,
     * false otherwise
     */
    public boolean canKill(ChessPiece piece) {
        return super.canKill(piece);
    }
}
