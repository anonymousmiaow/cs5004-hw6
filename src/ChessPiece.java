/**
 * This interface contains all operations that all types of ChessPieces
 * should support.
 */

public interface ChessPiece {

    /**
     * Return the current row of this chess piece on the chess board.
     * @return the current row of this chess piece on the chess board.
     */
    int getRow();

    /**
     * Return the current column of this chess piece on the chess board.
     * @return the current column of this chess piece on the chess board.
     */
    int getColumn();

    /**
     * Return the color of the ChessPiece.
     * @return the color of the chess piece.
     */
    ChessPieceImplementation.TypeOfColor getColor();

    /**
     *  Determine if this chess piece can move to a given cell.
     *  Return true if it can move there, false otherwise.
     * @return true if this chess piece can move to a given cell, false otherwise
     */
    boolean canMove(int col, int row);

    /**
     * Determine if this chess piece can kill a provided piece starting
     * from where it currently is. Return true if it can kill the provided
     * piece, false otherwise.
     * @return true if this chess piece can kill the provided piece,
     * false otherwise
     */
    boolean canKill(ChessPiece piece);
}

