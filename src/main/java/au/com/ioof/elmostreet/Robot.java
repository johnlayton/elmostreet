package au.com.ioof.elmostreet;

import au.com.ioof.elmostreet.commands.Placement;

public final class Robot {

    private final Table table;

    public Robot(final Table table) {
        this.table = table;
    }

    public void handle(final Placement placement) {
        if (!table.contains(placement.getX(), placement.getY())) {
            throw new RuntimeException("Invalid placement");
        }
    }
}
