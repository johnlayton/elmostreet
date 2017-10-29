package au.com.ioof.elmostreet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static au.com.ioof.elmostreet.Command.Left.LEFT;
import static au.com.ioof.elmostreet.Command.Move.MOVE;
import static au.com.ioof.elmostreet.Command.NoOp.NO_OP;
import static au.com.ioof.elmostreet.Command.Report.REPORT;
import static au.com.ioof.elmostreet.Command.Right.RIGHT;

public abstract class Command {

    public static interface Visitor<T> {
        T visit(Placement command);
        T visit(Left command);
        T visit(Right command);
        T visit(Move command);
        T visit(Report command);
        T visit(NoOp command);
    }

    public static class Placement extends Command {

        public static final Pattern PATTERN = Pattern.compile("PLACE (?<x>\\d+),(?<y>\\d+),(?<facing>NORTH|EAST|SOUTH|WEST)");

        private final Position position;
        private final Facing facing;

        public Placement(final Position position,
                         final Facing facing) {
            this.position = position;
            this.facing = facing;
        }

        @Override
        public <T> T accept(Visitor<T> visitor) {
            return visitor.visit(this);
        }

        public Position getPosition() {
            return position;
        }

        public Facing getFacing() {
            return facing;
        }
    }

    public static final class Left extends Command {
        public static final Pattern PATTERN = Pattern.compile("LEFT");
        public static final Left LEFT = new Left();

        @Override
        public <T> T accept(Visitor<T> visitor) {
            return visitor.visit(this);
        }
    }

    public static final class Right extends Command {
        public static final Pattern PATTERN = Pattern.compile("RIGHT");
        public static final Right RIGHT = new Right();

        @Override
        public <T> T accept(Visitor<T> visitor) {
            return visitor.visit(this);
        }
    }

    public static final class Move extends Command {
        public static final Pattern PATTERN = Pattern.compile("MOVE");
        public static final Move MOVE = new Move();

        @Override
        public <T> T accept(Visitor<T> visitor) {
            return visitor.visit(this);
        }
    }

    public static final class Report extends Command {
        public static final Pattern PATTERN = Pattern.compile("REPORT");
        public static final Report REPORT = new Report();

        @Override
        public <T> T accept(Visitor<T> visitor) {
            return visitor.visit(this);
        }
    }

    public static final class NoOp extends Command {
        public static final NoOp NO_OP = new NoOp();

        @Override
        public <T> T accept(Visitor<T> visitor) {
            return visitor.visit(this);
        }
    }

    public static Command parse(final String command) {
        if (Left.PATTERN.matcher(command).matches()) {
            return LEFT;
        } else if (Right.PATTERN.matcher(command).matches()) {
            return RIGHT;
        } else if (Move.PATTERN.matcher(command).matches()) {
            return MOVE;
        } else if (Report.PATTERN.matcher(command).matches()) {
            return REPORT;
        } else if (Placement.PATTERN.matcher(command).matches()) {
            return createPlacementCommand(command);
        } else {
            return NO_OP;
        }
    }

    private static Command createPlacementCommand(String command) {
        final Matcher matcher = Placement.PATTERN.matcher(command);
        if (matcher.matches()) {
            return new Placement(new Position(Integer.parseInt(matcher.group("x"), 10),
                                              Integer.parseInt(matcher.group("y"), 10)),
                                 Facing.valueOf(matcher.group("facing")));
        } else {
            return NO_OP;
        }
    }

    public abstract <T> T accept(final Visitor<T> visitor);
}
