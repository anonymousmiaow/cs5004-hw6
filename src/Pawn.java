/**
 * This class represents a Pawn.
 * A Knight has its position as a row and column,
 * and a color as an enum Color with values BLACK or WHITE.
 * Upper corner left is (0,0), and before starting the game,
 * it is a BLACK Rook at this position.
 */

public class Pawn extends ChessPieceImplementation {

    /**
     * Constructs a Knight and initializes
     * its initial position as a row and column, and a
     * color as an enum Color with values BLACK and WHITE.
     *
     * @param row    the row of this piece
     * @param column the column of this piece
     * @param color  the color of this piece
     */
    public Pawn(int column, int row, TypeOfColor color) {
        super(column, row, color);
    }

    /**
     * Determine if this Knight can move to a given cell.
     * Return true if it can move there, false otherwise.
     * A Pawn can move only "ahead": one cell
     *
     * @return true if this chess piece can move to a given cell, false otherwise
     */
    @Override
    public boolean canMove(int col, int row) {
        if (!super.canMove(col, row)) return false;
        if (getColor().equals(TypeOfColor.BLACK)){
            return (row - this.getRow() == -1) && (col == this.getColumn());
        }
        else if (getColor().equals(TypeOfColor.WHITE)){
            return (row - this.getRow() == 1) && (col == this.getColumn());
        }
        return false;
    }

    /**
     * Determine if this chess piece can kill a provided piece starting
     * from where it currently is. Return true if it can kill the provided
     * piece, false otherwise.
     * A Pawn can kill any opponent’s piece if it has one place forward diagonally to its place.
     *
     * @return true if this chess piece can kill the provided piece,
     * false otherwise
     */
    @Override
    public boolean canKill(ChessPiece piece) {
        boolean situation = false;
        if (piece == null) {
            return false;
        }
        else if (piece.getColor().equals(this.getColor())) {
            return false;
        }
        else if (TypeOfColor.WHITE.equals(piece.getColor())) {
            situation = (piece.getRow() - this.getRow() == -1) && (Math.abs(piece.getColumn() - this.getColumn()) == 1);
        }
        else if (TypeOfColor.BLACK.equals(piece.getColor())) {
            situation = (piece.getRow() - this.getRow() == 1) && (Math.abs(piece.getColumn() - this.getColumn()) == 1);
        }
        return situation;
    }
}
