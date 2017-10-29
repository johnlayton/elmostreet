package au.com.ioof.elmostreet;

import static au.com.ioof.elmostreet.Facing.EAST;
import static au.com.ioof.elmostreet.Facing.NORTH;

public final class Table {

    private final Position min = new Position(0, 0);
    private final Position max;

    public Table(final int x,
                 final int y) {
        if (x < 1 || y < 1) {
            throw new RuntimeException("Invalid table size");
        }
        this.max = new Position(x - 1, x - 1);
    }

    public boolean contains(final Position position) {
        return position.ge(min, NORTH)
                && position.ge(min, EAST)
                && max.ge(position, NORTH)
                && max.ge(position, EAST);
    }

    public String toString() {
        return String.format("min %s max %s", min, max);
    }
}
