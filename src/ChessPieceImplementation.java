/**
 * This class represents an Abstract Chess Piece.
 * An Abstract Chess Piece has its position as a row and column,
 * and a color as an enum Color with values BLACK or WHITE.
 */

public class ChessPieceImplementation implements ChessPiece {
    private int row, column;
    public enum TypeOfColor {BLACK, WHITE}
    private TypeOfColor color;

    /**
     * Constructs an AbstractCHessPiece and initializes
     * its initial position as a row and column, and a
     * color as an enum Color with values BLACK and WHITE.
     * @param row the row of this piece
     * @param column the column of this piece
     * @param color the color of this piece
     */
    public ChessPieceImplementation(int column, int row, TypeOfColor color) {
        setColumn(column);
        setRow(row);
        setColor(color);
    }

    /**
     * Return the current row of this chess piece on the chess board.
     * @return the current row of this chess piece on the chess board.
     */
    public int getRow() {
        return row;
    }

    /**
     * Return the current column of this chess piece on the chess board.
     * @return the current column of this chess piece on the chess board.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Return the color of the ChessPiece.
     * @return the color of the chess piece.
     */
    public TypeOfColor getColor() {
        return color;
    }

    /**
     * Set the row of this chess piece on the chess board.
     * @param row the row of this piece
     * @throws IllegalArgumentException if the input row is out of boundary.
     */
    public void setRow(int row) {
        if (row < 0 || row > 7) {
            throw new IllegalArgumentException("Invalid row: " + row);
        }
        this.row = row;
    }

    /**
     * Set the column of this chess piece on the chess board.
     * @param column  the row of this piece
     * @throws IllegalArgumentException if the input row is out of boundary.
     */
    public void setColumn(int column) {
        if (column < 0 || column > 7) {
            throw new IllegalArgumentException("Invalid column: " + column);
        }
        this.column = column;
    }

    /**
     * Set the color of the ChessPiece.
     * @param color the color of the chess piece.
     */
    public void setColor(TypeOfColor color) {
        this.color = color;
    }

    /**
     *  Determine if this chess piece can move to a given cell.
     *  A piece cannot move to the current position, or go
     *  outside the chessboard.
     *  Return true if it can move there, false otherwise.
     * @return true if this chess piece can move to a given cell, false otherwise
     */
    public boolean canMove(int col, int row) {
        // 1. a piece cannot move to the current position
        if ((row  == this.row) && (col == this.column)) return false;
        // 2. a piece cannot go outside the chessboard
        if (row > 7 || row < 0 || col < 0 || col > 7) return false;
        return true;
    }

    /**
     * Determine if this chess piece can kill a provided piece starting
     * from where it currently is. Return true if it can kill the provided
     * piece, false otherwise.
     * A bishop can kill any opponent’s piece if it can move to this place.
     * @return true if this chess piece can kill the provided piece,
     * false otherwise
     */
    public boolean canKill(ChessPiece piece) {
        if (piece == null) {
            return false;
        }
        if (piece.getColor() == color) {
            return false;
        }

        return canMove(piece.getColumn(), piece.getRow());
    }
}
