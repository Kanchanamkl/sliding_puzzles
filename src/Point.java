import java.util.Objects;

public class Point {
    private int x;
    private int y;
    private long totalCost;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.totalCost = 0;
    }

    public Point(){

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setTotalCost(long cost) {
        this.totalCost = cost;
    }

    public long getTotalCost() {
        return totalCost;
    }


    @Override
    public String toString() {
        return "(" + (x + 1) + "," + (y + 1) + ")";
    }
}
enum Direction {
    LEFT,
    RIGHT,
    UP,
    DOWN
}