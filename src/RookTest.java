import org.junit.Assert;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RookTest {

    private Rook r1, r2, r3, r4, r5;

    @org.junit.Before
    public void setUp(){
        r1 = new Rook(0, 0, ChessPieceImplementation.TypeOfColor.WHITE);
        r2 = new Rook(2,2, ChessPieceImplementation.TypeOfColor.WHITE);
        r3 = new Rook(2, 3, ChessPieceImplementation.TypeOfColor.BLACK);
        r4 = new Rook(3, 2, ChessPieceImplementation.TypeOfColor.BLACK);
        r5 = new Rook(3, 4, ChessPieceImplementation.TypeOfColor.BLACK);
    }

    @org.junit.Test
    public void getRow() {
        Assert.assertEquals(0, r1.getRow());
        Assert.assertEquals(2, r2.getRow());
        Assert.assertEquals(3, r3.getRow());
        Assert.assertEquals(4, r5.getRow());
    }

    @org.junit.Test
    public void getColumn() {
        Assert.assertEquals(0, r1.getColumn());
        Assert.assertEquals(2, r2.getColumn());
        Assert.assertEquals(2, r3.getColumn());
        Assert.assertEquals(3, r4.getColumn());
    }

    @org.junit.Test
    public void getColor() {
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.WHITE, r1.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.WHITE, r2.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.BLACK, r3.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.BLACK, r4.getColor());
    }

    @org.junit.Test
    public void setRow() {
        // 1. valid row
        r1.setRow(5);
        r2.setRow(3);
        r3.setRow(4);
        Assert.assertEquals(5, r1.getRow());
        Assert.assertEquals(3, r2.getRow());
        Assert.assertEquals(4, r3.getRow());
    }

    @org.junit.Test (expected = IllegalArgumentException.class)
    public void setRowInvalidInput() {
        // 2. invalid row
        r1.setRow(-5);
        r2.setRow(9);
        r3.setRow(8);
        Assert.assertEquals(5, r1.getRow());
        Assert.assertEquals(3, r2.getRow());
        Assert.assertEquals(4, r3.getRow());
    }

    @org.junit.Test
    public void setColumn() {
        // 1. valid row
        r1.setColumn(7);
        r2.setColumn(0);
        r3.setColumn(4);
        Assert.assertEquals(7, r1.getColumn());
        Assert.assertEquals(0, r2.getColumn());
        Assert.assertEquals(4, r3.getColumn());
    }

    @org.junit.Test (expected = IllegalArgumentException.class)
    public void setColumnInvalidInput() {
        // 2. invalid column
        r1.setColumn(10);
        r2.setColumn(-3);
        r3.setColumn(8);
        Assert.assertEquals(7, r1.getColumn());
        Assert.assertEquals(0, r2.getColumn());
        Assert.assertEquals(4, r3.getColumn());

    }

    @org.junit.Test
    public void setColor() {
        r1.setColor(ChessPieceImplementation.TypeOfColor.WHITE);
        r2.setColor(ChessPieceImplementation.TypeOfColor.BLACK);
        r3.setColor(ChessPieceImplementation.TypeOfColor.BLACK);
        r4.setColor(ChessPieceImplementation.TypeOfColor.WHITE);
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.WHITE, r1.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.BLACK, r2.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.BLACK, r3.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.WHITE, r4.getColor());
    }

    @org.junit.Test
    public void canMove() {
        // can move
        assertTrue(r1. canMove(1, 0));
        assertTrue(r2. canMove(2, 1));
        assertTrue(r3. canMove(0, 3));
        assertTrue(r4. canMove(3, 0));

        // cannot move 1 -- Not a horizontal or vertical move
        assertFalse(r1. canMove(3, 4));
        assertFalse(r2. canMove(3, 5));
        assertFalse(r3. canMove(6, 4));
        assertFalse(r4. canMove(4, 1));

        // cannot move 2 -- stay the current position
        assertFalse(r1. canMove(0, 0));
        assertFalse(r2. canMove(2, 2));
        assertFalse(r3. canMove(2, 3));
        assertFalse(r4. canMove(3, 2));

        // cannot move 3 -- outside the chessboard
        assertFalse(r1. canMove(-3, 1));
        assertFalse(r2. canMove(9, 1));
        assertFalse(r3. canMove(0, 10));
        assertFalse(r4. canMove(4, -4));

    }

    @org.junit.Test
    public void canKill() {
        // can kill
        assertTrue(r2.canKill(r3));

        // cannot kill 1 -- same color
        assertFalse(r1.canKill(r2));

        // cannot kill 2 -- cannot move to the position
        assertFalse(r2.canKill(r5));
    }
}

