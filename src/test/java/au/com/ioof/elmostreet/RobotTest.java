package au.com.ioof.elmostreet;

import au.com.ioof.elmostreet.Command.Placement;
import org.junit.Test;

import static au.com.ioof.elmostreet.Command.Move.MOVE;
import static au.com.ioof.elmostreet.Command.NoOp.NO_OP;
import static au.com.ioof.elmostreet.Command.Report.REPORT;
import static au.com.ioof.elmostreet.Command.Right.RIGHT;
import static au.com.ioof.elmostreet.Facing.EAST;
import static au.com.ioof.elmostreet.Facing.WEST;
import static org.junit.Assert.assertEquals;

public class RobotTest {

    @Test
    public void shouldIgnoreCommandToMoveOffWestTable() throws Exception {
        new Robot(new Table(5, 5), report -> {
            assertEquals("0,0,WEST", report);
        }).visit(new Placement(new Position(0, 0), WEST))
          .visit(MOVE)
          .visit(REPORT);
    }

    @Test
    public void shouldIgnoreCommandToMoveOffEastTable() throws Exception {
        new Robot(new Table(5, 5), report -> {
            assertEquals("4,0,EAST", report);
        }).visit(new Placement(new Position(4, 0), EAST))
          .visit(MOVE)
          .visit(REPORT);
    }

    @Test
    public void shouldIgnoreCommandsPreceedingPlacement() throws Exception {
        new Robot(new Table(5, 5), report -> {
            assertEquals("1,0,EAST", report);
        }).visit(MOVE)
          .visit(RIGHT)
          .visit(new Placement(new Position(0, 0), EAST))
          .visit(MOVE)
          .visit(REPORT);
    }

    @Test
    public void shouldIgnoreNoOpCommands() throws Exception {
        new Robot(new Table(5, 5), report -> {
            assertEquals("1,0,EAST", report);
        }).visit(MOVE)
          .visit(RIGHT)
          .visit(new Placement(new Position(0, 0), EAST))
          .visit(MOVE)
          .visit(NO_OP)
          .visit(REPORT);
    }

    @Test
    public void shouldAllowPlacementOfRobotInCommandStream() throws Exception {
        new Robot(new Table(5, 5), report -> {
            assertEquals("0,0,EAST", report);
        }).visit(MOVE)
          .visit(RIGHT)
          .visit(new Placement(new Position(0, 0), EAST))
          .visit(MOVE)
          .visit(new Placement(new Position(0, 0), EAST))
          .visit(REPORT);
    }
}
