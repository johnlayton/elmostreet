package au.com.ioof.elmostreet;

import org.junit.Test;

import static au.com.ioof.elmostreet.Facing.EAST;
import static au.com.ioof.elmostreet.Facing.NORTH;
import static au.com.ioof.elmostreet.Facing.SOUTH;
import static au.com.ioof.elmostreet.Facing.WEST;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PositionTest {

    @Test
    public void shouldReturnTrueWhenComparedToPosition() throws Exception {
        assertTrue(new Position(4, 4).greaterThanOrEqualInDirection(new Position(4, 3), NORTH));
        assertTrue(new Position(4, 4).greaterThanOrEqualInDirection(new Position(3, 4), EAST));
        assertTrue(new Position(4, 4).greaterThanOrEqualInDirection(new Position(4, 5), SOUTH));
        assertTrue(new Position(4, 4).greaterThanOrEqualInDirection(new Position(5, 4), WEST));
    }

    @Test
    public void shouldReturnFalseWhenComparedToPosition() throws Exception {
        assertFalse(new Position(4, 4).greaterThanOrEqualInDirection(new Position(4, 5), NORTH));
        assertFalse(new Position(4, 4).greaterThanOrEqualInDirection(new Position(5, 4), EAST));
        assertFalse(new Position(4, 4).greaterThanOrEqualInDirection(new Position(4, 3), SOUTH));
        assertFalse(new Position(4, 4).greaterThanOrEqualInDirection(new Position(3, 4), WEST));
    }

    @Test
    public void shouldReturnNewPosition() throws Exception {
        assertEquals(new Position(4, 4).moveInDirection(NORTH), new Position(4, 5));
        assertEquals(new Position(4, 4).moveInDirection(EAST), new Position(5, 4));
        assertEquals(new Position(4, 4).moveInDirection(SOUTH), new Position(4, 3));
        assertEquals(new Position(4, 4).moveInDirection(WEST), new Position(3, 4));
    }
}
