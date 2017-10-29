package au.com.ioof.elmostreet;

import java.util.Objects;

public final class Position {

    private final int x;
    private final int y;

    public Position(final int x,
                    final int y) {
        this.x = x;
        this.y = y;
    }

    public Position move(final Facing facing) {
        switch (facing) {
            case NORTH:
                return new Position(x, y + 1);
            case EAST:
                return new Position(x + 1, y);
            case SOUTH:
                return new Position(x, y - 1);
            case WEST:
                return new Position(x - 1, y);
            default:
                return this;
        }
    }

    public boolean ge(final Position position,
                      final Facing facing) {
        switch (facing) {
            case NORTH:
                return y >= position.y;
            case EAST:
                return x >= position.x;
            case SOUTH:
                return y <= position.y;
            case WEST:
                return x <= position.x;
            default:
                return false;
        }
    }

    public String toString() {
        return String.format("%d,%d", x, y);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return x == position.x
                && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
