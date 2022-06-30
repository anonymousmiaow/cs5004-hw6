import org.junit.Assert;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/* JUnit Test for the Knight Class */

public class KnightTest {

    private Knight b1, b2, b3, b4;

    @org.junit.Before
    public void setUp(){
        b1 = new Knight(1, 7, ChessPieceImplementation.TypeOfColor.WHITE);
        b2 = new Knight(6, 7, ChessPieceImplementation.TypeOfColor.WHITE);
        b3 = new Knight(6, 0, ChessPieceImplementation.TypeOfColor.BLACK);
        b4 = new Knight(2, 5, ChessPieceImplementation.TypeOfColor.BLACK);
    }

    @org.junit.Test
    public void getRow() {
        Assert.assertEquals(7, b1.getRow());
        Assert.assertEquals(7, b2.getRow());
        Assert.assertEquals(0, b3.getRow());
        Assert.assertEquals(5, b4.getRow());
    }

    @org.junit.Test
    public void getColumn() {
        Assert.assertEquals(1, b1.getColumn());
        Assert.assertEquals(6, b2.getColumn());
        Assert.assertEquals(6, b3.getColumn());
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
        b2.setRow(3);
        b3.setRow(4);
        Assert.assertEquals(3, b2.getRow());
        Assert.assertEquals(4, b3.getRow());
    }

    @org.junit.Test (expected = IllegalArgumentException.class)
    public void setRowInvalidInput() {
        // 2. invalid row
        b2.setRow(9);
        b3.setRow(8);
        Assert.assertEquals(3, b2.getRow());
        Assert.assertEquals(4, b3.getRow());
    }

    @org.junit.Test
    public void setColumn() {
        // 1. valid column
        b2.setColumn(0);
        b3.setColumn(4);
        Assert.assertEquals(0, b2.getColumn());
        Assert.assertEquals(4, b3.getColumn());
    }

    @org.junit.Test (expected = IllegalArgumentException.class)
    public void setColumnInvalidInput() {
        // 2. invalid column
        b2.setColumn(-3);
        b3.setColumn(8);
        Assert.assertEquals(0, b2.getColumn());
        Assert.assertEquals(4, b3.getColumn());

    }

    @org.junit.Test
    public void setColor() {
        b2.setColor(ChessPieceImplementation.TypeOfColor.BLACK);
        b3.setColor(ChessPieceImplementation.TypeOfColor.WHITE);
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.BLACK, b2.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.WHITE, b3.getColor());
    }

    @org.junit.Test
    public void canMove() {
        // can move
        assertTrue(b1. canMove(3, 6));
        assertTrue(b2. canMove(5, 5));
        assertTrue(b3. canMove(4, 1));
        assertTrue(b4. canMove(4, 4));

        // cannot move 1 -- stay the current position
        assertFalse(b1. canMove(1, 7));
        assertFalse(b2. canMove(6, 7));
        assertFalse(b3. canMove(6, 0));
        assertFalse(b4. canMove(2, 5));

        // cannot move 2 -- not move L pattern
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
        assertTrue(b4.canKill(b1));

        // cannot kill 1 -- same color
        assertFalse(b3.canKill(b4));

        // cannot kill 2 -- cannot move to the position
        assertFalse(b2.canKill(b3));
    }
}