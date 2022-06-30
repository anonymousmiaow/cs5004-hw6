import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QueenTest {

    private Queen q1, q2, q3, q4, q5;

    @org.junit.Before
    public void setUp(){
        q1 = new Queen(0, 0, ChessPieceImplementation.TypeOfColor.WHITE);
        q2 = new Queen(2,2, ChessPieceImplementation.TypeOfColor.WHITE);
        q3 = new Queen(5, 5, ChessPieceImplementation.TypeOfColor.BLACK);
        q4 = new Queen(7, 7, ChessPieceImplementation.TypeOfColor.BLACK);
        q5 = new Queen(3, 4, ChessPieceImplementation.TypeOfColor.BLACK);
    }

    @Test
    public void getRow() {
        Assert.assertEquals(0, q1.getRow());
        Assert.assertEquals(2, q2.getRow());
        Assert.assertEquals(5, q3.getRow());
        Assert.assertEquals(7, q4.getRow());
    }

    @Test
    public void getColumn() {
        Assert.assertEquals(0, q1.getColumn());
        Assert.assertEquals(2, q2.getColumn());
        Assert.assertEquals(5, q3.getColumn());
        Assert.assertEquals(7, q4.getColumn());
    }

    @Test
    public void getColor() {
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.WHITE, q1.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.WHITE, q2.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.BLACK, q3.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.BLACK, q4.getColor());
    }

    @Test
    public void setRow() {
        // 1. valid row
        q1.setRow(5);
        q2.setRow(3);
        q3.setRow(4);
        Assert.assertEquals(5, q1.getRow());
        Assert.assertEquals(3, q2.getRow());
        Assert.assertEquals(4, q3.getRow());
    }

    @Test (expected = IllegalArgumentException.class)
    public void setRowInvalidInput() {
        // 2. invalid row
        q1.setRow(-5);
        q2.setRow(9);
        q3.setRow(8);
        Assert.assertEquals(5, q1.getRow());
        Assert.assertEquals(3, q2.getRow());
        Assert.assertEquals(4, q3.getRow());
    }

    @Test
    public void setColumn() {
        // 1. valid row
        q1.setColumn(7);
        q2.setColumn(0);
        q3.setColumn(4);
        Assert.assertEquals(7, q1.getColumn());
        Assert.assertEquals(0, q2.getColumn());
        Assert.assertEquals(4, q3.getColumn());
    }

    @Test (expected = IllegalArgumentException.class)
    public void setColumnInvalidInput() {
        // 2. invalid column
        q1.setColumn(10);
        q2.setColumn(-3);
        q3.setColumn(8);
        Assert.assertEquals(7, q1.getColumn());
        Assert.assertEquals(0, q2.getColumn());
        Assert.assertEquals(4, q3.getColumn());

    }

    @Test
    public void setColor() {
        q1.setColor(ChessPieceImplementation.TypeOfColor.WHITE);
        q2.setColor(ChessPieceImplementation.TypeOfColor.BLACK);
        q3.setColor(ChessPieceImplementation.TypeOfColor.BLACK);
        q4.setColor(ChessPieceImplementation.TypeOfColor.WHITE);
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.WHITE, q1.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.BLACK, q2.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.BLACK, q3.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.WHITE, q4.getColor());
    }

    @Test
    public void canMove() {
        // can move
        assertTrue(q1. canMove(1, 1));
        assertTrue(q2. canMove(2, 1));
        assertTrue(q3. canMove(0, 5));
        assertTrue(q4. canMove(7, 3));

        // cannot move 1 -- Not a diagonal/horizontal/vertical move
        assertFalse(q1. canMove(3, 4));
        assertFalse(q2. canMove(3, 5));
        assertFalse(q3. canMove(6, 3));
        assertFalse(q4. canMove(4, 1));

        // cannot move 2 -- stay the current position
        assertFalse(q1. canMove(0, 0));
        assertFalse(q2. canMove(2, 2));
        assertFalse(q3. canMove(5, 5));
        assertFalse(q4. canMove(7, 7));

        // cannot move 3 -- outside the chessboard
        assertFalse(q1. canMove(-3, 1));
        assertFalse(q2. canMove(9, 1));
        assertFalse(q3. canMove(0, 10));
        assertFalse(q4. canMove(4, -4));

    }

    @Test
    public void canKill() {
        // can kill
        assertTrue(q1.canKill(q4));

        // cannot kill 1 -- same color
        assertFalse(q1.canKill(q2));

        // cannot kill 2 -- cannot move to the position
        assertFalse(q2.canKill(q5));
    }
}

