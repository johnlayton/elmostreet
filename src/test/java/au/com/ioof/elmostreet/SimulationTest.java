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

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionIfNotSuppliedScenario() throws Exception {
        Simulation.main(new String[] {});
    }

    @Test
    public void shouldCompleteScenario1() throws Exception {
        Simulation.main(getSimulationArgs("scenario1.txt"));
        assertEquals("0,1,NORTH\n", stdout.toString());
    }

    @Test
    public void shouldCompleteScenario2() throws Exception {
        Simulation.main(getSimulationArgs("scenario2.txt"));
        assertEquals("0,0,WEST\n", stdout.toString());
    }

    @Test
    public void shouldCompleteScenario3() throws Exception {
        Simulation.main(getSimulationArgs("scenario3.txt"));
        assertEquals("3,3,NORTH\n", stdout.toString());
    }

    @Test
    public void shouldIgnoreWhenNoValidCommands() throws Exception {
        Simulation.main(getSimulationArgs("scenario4.txt"));
        assertEquals("", stdout.toString());
    }

    @Test
    public void shouldIgnoreWhenNoValidPlacementCommands() throws Exception {
        Simulation.main(getSimulationArgs("scenario5.txt"));
        assertEquals("", stdout.toString());
    }

    @Test
    public void shouldIgnoreCommandsPreceedingPlacementCommands() throws Exception {
        Simulation.main(getSimulationArgs("scenario6.txt"));
        assertEquals("0,1,NORTH\n", stdout.toString());
    }

    private String[] getSimulationArgs(final String scenario) throws Exception {
        return new String[] {
                getInputFile(scenario)
        };
    }

    private String getInputFile(final String scenario) throws Exception {
        return new File(getClass().getResource("/" + scenario).toURI()).getAbsolutePath();
    }

}
