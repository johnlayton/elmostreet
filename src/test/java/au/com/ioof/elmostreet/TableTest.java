package au.com.ioof.elmostreet;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TableTest {

    @Test
    public void shouldReturnTrueForPointsOnTable() throws Exception {
        assertTrue(new Table(5,5).contains(0,0));
        assertTrue(new Table(5,5).contains(4,4));
    }

    @Test
    public void shouldReturnFalseForPointsNotOnTable() throws Exception {
        assertFalse(new Table(5,5).contains(-1,-1));
        assertFalse(new Table(5,5).contains(5,5));
    }
}
