package au.com.ioof.elmostreet;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TableTest {

    @Test
    public void shouldContainPositions() throws Exception {
        assertTrue(new Table(5, 5).contains(new Position(4, 4)));
        assertTrue(new Table(5, 5).contains(new Position(0, 4)));
        assertTrue(new Table(5, 5).contains(new Position(4, 0)));
        assertTrue(new Table(5, 5).contains(new Position(0, 0)));
    }

    @Test
    public void shouldNotContainPositions() throws Exception {
        assertFalse(new Table(5, 5).contains(new Position(4, 5)));
        assertFalse(new Table(5, 5).contains(new Position(5, 4)));
        assertFalse(new Table(5, 5).contains(new Position(-1, 0)));
        assertFalse(new Table(5, 5).contains(new Position(0, -1)));
    }

    @Test(expected = RuntimeException.class)
    public void shouldExceptOnConstruction() throws Exception {
        new Table(0, 0);
    }
}
