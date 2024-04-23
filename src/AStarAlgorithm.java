import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AStarAlgorithm {
    public static long findMazePath(Maze maze) {
        Instant start = Instant.now();

        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingLong(Point::getTotalCost));
        Point[][] mazePoint = new Point[maze.getMaze().length][maze.getMaze()[0].length];

        queue.add(new Point(maze.getStartX(), maze.getStartY()));
        mazePoint[maze.getStartY()][maze.getStartX()] = new Point(maze.getStartX(), maze.getStartY());
        ArrayList<Point> path = new ArrayList<>();

        boolean slidingMaze = true;

        while (!queue.isEmpty() && slidingMaze) {
            Point currentMazePosition = queue.poll();

            // Travel through adjacent points while sliding on the '.' characters (ice) using a for loop.
            for (Direction direction : Direction.values()) {
                Point nextMazePosition = move(maze.getMaze(), mazePoint, currentMazePosition, direction, maze.getFinishY(), maze.getFinishX());

                if (nextMazePosition != null) {
                    queue.add(nextMazePosition);
                    mazePoint[nextMazePosition.getY()][nextMazePosition.getX()] = new Point(currentMazePosition.getX(), currentMazePosition.getY());
                    if (nextMazePosition.getY() == maze.getFinishY() && nextMazePosition.getX() == maze.getFinishX()) {

                        // The end point is determined.
                        Point temp = nextMazePosition;
                        while (!temp.equals(mazePoint[temp.getY()][temp.getX()])) {
                            path.add(0, temp);
                            temp = mazePoint[temp.getY()][temp.getX()];
                        }
                        slidingMaze = false;
                        break;
                    }
                }
            }
        }

        path.add(new Point(maze.getFinishX(), maze.getFinishY()));

        // Displaying the shortest path from start to finish in the maze.
        for (int x = 0; x < path.size(); x++) {
            if (x != 0) {
                if (path.get(x - 1).getX() < path.get(x).getX()) {
                    System.out.println("Move right to  " + path.get(x));
                } else if (path.get(x - 1).getX() > path.get(x).getX()) {
                    System.out.println("Move left to   " + path.get(x));
                } else if (path.get(x - 1).getY() < path.get(x).getY()) {
                    System.out.println("Move down to   " + path.get(x));
                } else if (path.get(x - 1).getY() > path.get(x).getY()) {
                    System.out.println("Move up to     " + path.get(x));
                }
            } else {
                System.out.println("Start at       " + path.get(x));
            }

        }
        System.out.println("Done!");

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();

        return timeElapsed;
    }

    // This method determines whether they can slide in the chosen direction.
    public static Point move(String[][] maze, Point[][] mazePoint, Point currentMazePosition, Direction direction, int finishY, int finishX) {
        int x = currentMazePosition.getX();
        int y = currentMazePosition.getY();

        int compareX = (direction == Direction.LEFT ? -1 : (direction == Direction.RIGHT ? 1 : 0));
        int compareY = (direction == Direction.UP ? -1 : (direction == Direction.DOWN ? 1 : 0));

        int i = 1;
        while (x + i * compareX >= 0 && x + i * compareX < maze[0].length && y + i * compareY >= 0
                && y + i * compareY < maze.length && !maze[y + i * compareY][x + i * compareX].equals("0")) {

            if (maze[y + i * compareY][x + i * compareX].equals("F")) {
                return new Point(finishX, finishY);
            }
            i++;
        }

        i--;

        if (mazePoint[y + i * compareY][x + i * compareX] != null) {
            // This point is already visited therefore returns null.
            return null;
        }

        return new Point(x + i * compareX, y + i * compareY);
    }
}