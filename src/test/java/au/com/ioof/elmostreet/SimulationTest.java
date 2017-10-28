package au.com.ioof.elmostreet;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SimulationTest {

    private final ByteArrayOutputStream stdout = new ByteArrayOutputStream();
    private final ByteArrayOutputStream stderr = new ByteArrayOutputStream();

    @Before
    public void before() {
        System.setOut(new PrintStream(stdout));
        System.setErr(new PrintStream(stderr));
    }

    @Test
    public void scenario1() throws Exception {
        Simulation.main(new String[] { getInputFile("scenario1.txt") });
        assertEquals("0,1,NORTH", stdout.toString());
    }

    @Test
    public void scenario2() throws Exception {
        Simulation.main(new String[] { getInputFile("scenario2.txt") });
        assertEquals("0,0,WEST", stdout.toString());
    }

    @Test
    public void scenario3() throws Exception {
        Simulation.main(new String[] { getInputFile("scenario3.txt") });
        assertEquals("3,3,NORTH", stdout.toString());
    }

    private String getInputFile(final String scenario) throws Exception {
        return new File(getClass().getResource("/" + scenario).toURI()).getAbsolutePath();
    }

}
