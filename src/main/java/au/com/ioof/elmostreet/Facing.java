package au.com.ioof.elmostreet;

import static au.com.ioof.elmostreet.Command.Left.LEFT;
import static au.com.ioof.elmostreet.Command.Right.RIGHT;

public enum Facing {

    NORTH, EAST, SOUTH, WEST;

    private static final int LEFT_INCREMENT = 3;
    private static final int RIGHT_INCREMENT = 5;

    public Facing rotate(final Command command) {
        if (LEFT == command) {
            return values()[(ordinal() + LEFT_INCREMENT) % values().length];
        } else if (RIGHT == command) {
            return values()[(ordinal() + RIGHT_INCREMENT) % values().length];
        } else {
            return this;
        }
    }
}
