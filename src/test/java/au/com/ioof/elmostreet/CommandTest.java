package au.com.ioof.elmostreet;

import au.com.ioof.elmostreet.Command.Left;
import au.com.ioof.elmostreet.Command.Move;
import au.com.ioof.elmostreet.Command.NoOp;
import au.com.ioof.elmostreet.Command.Placement;
import au.com.ioof.elmostreet.Command.Report;
import au.com.ioof.elmostreet.Command.Right;
import au.com.ioof.elmostreet.Command.Visitor;
import org.junit.Test;

import static au.com.ioof.elmostreet.Facing.NORTH;
import static au.com.ioof.elmostreet.Facing.WEST;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommandTest {

    @Test
    public void shouldParsePlacementCommand() throws Exception {
        assertEquals(Placement.class, Command.parse("PLACE 0,0,NORTH").getClass());
        assertTrue(Command.parse("PLACE 0,0,NORTH").accept(new BooleanVisitorAdapter() {
            @Override
            public Boolean visit(Placement command) {
                return command.getFacing() == NORTH && command.getPosition().equals(new Position(0, 0));
            }
        }));
        assertTrue(Command.parse("PLACE 0,0,WEST").accept(new BooleanVisitorAdapter() {
            @Override
            public Boolean visit(Placement command) {
                return command.getFacing() == WEST && command.getPosition().equals(new Position(0, 0));
            }
        }));
    }

    @Test
    public void shouldParseRotateLeftCommand() throws Exception {
        assertEquals(Left.class, Command.parse("LEFT").getClass());
    }

    @Test
    public void shouldParseRotateRightCommand() throws Exception {
        assertEquals(Right.class, Command.parse("RIGHT").getClass());
    }

    @Test
    public void shouldParseMoveCommand() throws Exception {
        assertEquals(Move.class, Command.parse("MOVE").getClass());
    }

    @Test
    public void shouldParseReportCommand() throws Exception {
        assertEquals(Report.class, Command.parse("REPORT").getClass());
    }

    @Test
    public void shouldParseNoOpCommand() throws Exception {
        assertEquals(NoOp.class, Command.parse("GARBAGE").getClass());
    }

    private static class BooleanVisitorAdapter implements Visitor<Boolean> {
        @Override
        public Boolean visit(Placement command) {
            return false;
        }

        @Override
        public Boolean visit(Left command) {
            return false;
        }

        @Override
        public Boolean visit(Right command) {
            return false;
        }

        @Override
        public Boolean visit(Move command) {
            return false;
        }

        @Override
        public Boolean visit(Report command) {
            return false;
        }

        @Override
        public Boolean visit(NoOp command) {
            return false;
        }
    }
}
