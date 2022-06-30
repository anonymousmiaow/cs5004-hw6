import org.junit.Assert;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/* JUnit Test for the Bishop Class */

public class BishopTest {

    private Bishop b1, b2, b3, b4;

    @org.junit.Before
    public void setUp(){
        b1 = new Bishop(0, 0, ChessPieceImplementation.TypeOfColor.WHITE);
        b2 = new Bishop(2, 3, ChessPieceImplementation.TypeOfColor.WHITE);
        b3 = new Bishop(5, 1, ChessPieceImplementation.TypeOfColor.BLACK);
        b4 = new Bishop(2, 2, ChessPieceImplementation.TypeOfColor.BLACK);
    }

    @org.junit.Test
    public void getRow() {
        Assert.assertEquals(0, b1.getRow());
        Assert.assertEquals(3, b2.getRow());
        Assert.assertEquals(1, b3.getRow());
        Assert.assertEquals(2, b4.getRow());
    }

    @org.junit.Test
    public void getColumn() {
        Assert.assertEquals(0, b1.getColumn());
        Assert.assertEquals(2, b2.getColumn());
        Assert.assertEquals(5, b3.getColumn());
        Assert.assertEquals(2, b4.getColumn());
    }

    @org.junit.Test
    public void getColor() {
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.WHITE, b1.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.WHITE, b2.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.BLACK, b3.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.BLACK, b4.getColor());

    }

    @org.junit.Test
    public void setRow() {
        // 1. valid row
        b1.setRow(5);
        b2.setRow(3);
        b3.setRow(4);
        Assert.assertEquals(5, b1.getRow());
        Assert.assertEquals(3, b2.getRow());
        Assert.assertEquals(4, b3.getRow());
    }

    @org.junit.Test (expected = IllegalArgumentException.class)
    public void setRowInvalidInput() {
        // 2. invalid row
        b1.setRow(-5);
        b2.setRow(9);
        b3.setRow(8);
        Assert.assertEquals(5, b1.getRow());
        Assert.assertEquals(3, b2.getRow());
        Assert.assertEquals(4, b3.getRow());
    }

    @org.junit.Test
    public void setColumn() {
        // 1. valid column
        b1.setColumn(7);
        b2.setColumn(0);
        b3.setColumn(4);
        Assert.assertEquals(7, b1.getColumn());
        Assert.assertEquals(0, b2.getColumn());
        Assert.assertEquals(4, b3.getColumn());
    }

    @org.junit.Test (expected = IllegalArgumentException.class)
    public void setColumnInvalidInput() {
        // 2. invalid column
        b1.setColumn(10);
        b2.setColumn(-3);
        b3.setColumn(8);
        Assert.assertEquals(7, b1.getColumn());
        Assert.assertEquals(0, b2.getColumn());
        Assert.assertEquals(4, b3.getColumn());

    }

    @org.junit.Test
    public void setColor() {
        b1.setColor(ChessPieceImplementation.TypeOfColor.WHITE);
        b2.setColor(ChessPieceImplementation.TypeOfColor.BLACK);
        b3.setColor(ChessPieceImplementation.TypeOfColor.BLACK);
        b4.setColor(ChessPieceImplementation.TypeOfColor.WHITE);
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.WHITE, b1.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.BLACK, b2.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.BLACK, b3.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.WHITE, b4.getColor());
    }

    @org.junit.Test
    public void canMove() {
        // can move
        assertTrue(b1. canMove(1, 1));
        assertTrue(b2. canMove(0, 1));
        assertTrue(b3. canMove(6, 0));
        assertTrue(b4. canMove(4, 0));

        // cannot move 1 -- Not a diagonal move
        assertFalse(b1. canMove(0, 1));
        assertFalse(b2. canMove(2, 5));
        assertFalse(b3. canMove(6, 3));
        assertFalse(b4. canMove(4, 1));

        // cannot move 2 -- stay the current position
        assertFalse(b1. canMove(0, 0));
        assertFalse(b2. canMove(2, 3));
        assertFalse(b3. canMove(5, 1));
        assertFalse(b4. canMove(2, 2));

        // cannot move 3 -- outside the chessboard
        assertFalse(b1. canMove(-3, 1));
        assertFalse(b2. canMove(9, 1));
        assertFalse(b3. canMove(0, 10));
        assertFalse(b4. canMove(4, -4));

    }

    @org.junit.Test
    public void canKill() {
        // can kill
        assertTrue(b1.canKill(b4));

        // cannot kill 1 -- same color
        assertFalse(b3.canKill(b4));

        // cannot kill 2 -- cannot move to the position
        assertFalse(b2.canKill(b3));
    }
}