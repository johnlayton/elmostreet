package au.com.ioof.elmostreet;

import static au.com.ioof.elmostreet.Command.Left.LEFT;
import static au.com.ioof.elmostreet.Command.Right.RIGHT;

public enum Facing {

    NORTH, EAST, SOUTH, WEST;

    public Facing rotate(final Command command) {
        if (LEFT == command) {
            return values()[(ordinal() + 3) % 4];
        } else if (RIGHT == command) {
            return values()[(ordinal() + 5) % 4];
        } else {
            return this;
        }
    }
}
