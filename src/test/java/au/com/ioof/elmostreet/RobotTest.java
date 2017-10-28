package au.com.ioof.elmostreet;

import au.com.ioof.elmostreet.commands.Placement;
import org.junit.Test;

public class RobotTest {

    @Test(expected = RuntimeException.class)
    public void shouldThowExceptionWhenNotPlacedOnTable() throws Exception {
        new Robot(new Table(5, 5)).handle(new Placement(6, 6, "NORTH"));
    }

}
