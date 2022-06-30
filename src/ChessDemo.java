public class ChessDemo {

    public static void main(String[] args) {
        ChessPiece bishop = new Bishop(1, 1, ChessPieceImplementation.TypeOfColor.WHITE);
        ChessPiece knight = new Knight(2, 3, ChessPieceImplementation.TypeOfColor.BLACK);

        // Get color & position
        System.out.println("Bishop position: (" + bishop.getColumn() + ", " + bishop.getRow() + ")");
        System.out.println("Bishop color: " + bishop.getColor());

        System.out.println("Knight position: (" + knight.getColumn() + ", " + knight.getRow() + ")");
        System.out.println("Knight color: " + knight.getColor());
        System.out.println("\n");

        // canMove
        System.out.println("Can the bishop piece move to (9, 4)? " + bishop.canMove(9, 4));
        System.out.println("Can the bishop piece move to (1, 1)? " + bishop.canMove(1, 1));
        System.out.println("Can the bishop piece move to (2, 4)? " + bishop.canMove(2, 4));
        System.out.println("Can the bishop piece move to (5, 5)? " + bishop.canMove(5, 5));
        System.out.println("\n");

        System.out.println("Can the Knight piece move to (9, 4)? " + knight.canMove(9, 4));
        System.out.println("Can the Knight piece move to (2, 3)? " + knight.canMove(2, 3));
        System.out.println("Can the Knight piece move to (5, 4)? " + knight.canMove(5, 4));
        System.out.println("Can the Knight piece move to (3, 5)? " + knight.canMove(3, 5));
        System.out.println("\n");

        // canKill
        System.out.println("Can the bishop kill the knight? " + bishop.canKill(knight));
    }
}
