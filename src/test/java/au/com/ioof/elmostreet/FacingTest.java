package au.com.ioof.elmostreet;

import org.junit.Test;

import static au.com.ioof.elmostreet.Command.Right.RIGHT;
import static au.com.ioof.elmostreet.Command.Left.LEFT;
import static au.com.ioof.elmostreet.Facing.NORTH;
import static au.com.ioof.elmostreet.Facing.EAST;
import static au.com.ioof.elmostreet.Facing.SOUTH;
import static au.com.ioof.elmostreet.Facing.WEST;
import static org.junit.Assert.assertEquals;

public class FacingTest {

    @Test
    public void shouldRotateRight() throws Exception {
        assertEquals(NORTH.rotate(RIGHT), EAST);
        assertEquals(EAST.rotate(RIGHT), SOUTH);
        assertEquals(SOUTH.rotate(RIGHT), WEST);
        assertEquals(WEST.rotate(RIGHT), NORTH);
    }

    @Test
    public void shouldRotateLeft() throws Exception {
        assertEquals(NORTH.rotate(LEFT), WEST);
        assertEquals(WEST.rotate(LEFT), SOUTH);
        assertEquals(SOUTH.rotate(LEFT), EAST);
        assertEquals(EAST.rotate(LEFT), NORTH);
    }

}
