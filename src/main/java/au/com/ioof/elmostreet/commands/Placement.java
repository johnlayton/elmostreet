package au.com.ioof.elmostreet.commands;

public class Placement {

    private final int x;
    private final int y;
    private final String f;

    public Placement(final int x,
                     final int y,
                     final String f) {
        this.x = x;
        this.y = y;
        this.f = f;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getF() {
        return f;
    }
}
