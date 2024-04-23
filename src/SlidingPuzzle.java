import java.io.IOException;
import java.util.Scanner;

public class SlidingPuzzle {

        public static void main(String[] args) throws IOException {
            Scanner console = new Scanner(System.in);

            // Asking the user for the file name along with the path
            System.out.print("\nEnter File Name With The Path : ");
            String fileName = console.nextLine();
            System.out.print("\n");

            MazeSolver mazeSolver = new MazeSolver();
            mazeSolver.solveMaze(fileName);
        }
    }

