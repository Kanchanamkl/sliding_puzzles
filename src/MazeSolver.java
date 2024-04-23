import java.io.IOException;

public class MazeSolver {
    public void solveMaze(String fileName) throws IOException {
        Maze maze = MazeReader.readMazeFromFile(fileName);
        if (maze != null) {
            AStarAlgorithm aStarAlgorithm = new AStarAlgorithm();
            long elapsedTime = aStarAlgorithm.findMazePath(maze);
            System.out.println("\nTime elapsed: " + elapsedTime + " milliseconds");
        }
    }
}