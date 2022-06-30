/**
 * This class represents a Rook.
 * A Rook has its position as a row and column,
 * and a color as an enum Color with values BLACK or WHITE.
 */

public class Rook extends ChessPieceImplementation {
    private int row;
    private int column;
    private TypeOfColor color;

    /**
     * Constructs a Rook and initializes
     * its initial position as a row and column, and a
     * color as an enum Color with values BLACK and WHITE.
     * @param row the row of this piece
     * @param column the column of this piece
     * @param color the color of this piece
     */
    public Rook(int column, int row, TypeOfColor color) {
        super(column, row, color);
    }

    /**
     *  Determine if this chess piece can move to a given cell.
     *  Return true if it can move there, false otherwise.
     *  A Rook can move horizontally or vertically.
     * @return true if this chess piece can move to a given cell, false otherwise
     */
    @Override
    public boolean canMove(int col, int row) {
        if (!super.canMove(col, row)) return false;
        return (row == this.getRow() || col == this.getColumn());
    }

    /**
     * Determine if this chess piece can kill a provided piece starting
     * from where it currently is. Return true if it can kill the provided
     * piece, false otherwise.
     * A Bishop can kill any opponent’s piece if it can move to its place.
     * @return true if this chess piece can kill the provided piece,
     * false otherwise
     */
    public boolean canKill(ChessPiece piece) {
        return super.canKill(piece);
    }
}

