package au.com.ioof.elmostreet;

public class Table {
    private final int x;
    private final int y;

    public Table(int x,
                 int y) {
        this.x = x;
        this.y = y;
    }

    public boolean contains(final int x, final int y){
        return x >= 0 && x < this.x && y >= 0 && y < this.y;
    }

}
