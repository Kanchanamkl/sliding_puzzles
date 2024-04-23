public class Maze {
    private String[][] maze;
    private int startY, startX, finishY, finishX;

    public Maze(String[][] maze, int startY, int startX, int finishY, int finishX) {
        this.maze = maze;
        this.startY = startY;
        this.startX = startX;
        this.finishY = finishY;
        this.finishX = finishX;
    }

    public String[][] getMaze() {
        return maze;
    }

    public int getStartY() {
        return startY;
    }

    public int getStartX() {
        return startX;
    }

    public int getFinishY() {
        return finishY;
    }

    public int getFinishX() {
        return finishX;
    }
}