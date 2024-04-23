import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MazeReader {
    public static Maze readMazeFromFile(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        int mazeHeight = 0;
        int mazeWidth = 0;
        int startY = 0, startX = 0, finishY = 0, finishX = 0;

        String mazeRow;
        while ((mazeRow = bufferedReader.readLine()) != null) {
            if (mazeHeight == 0) {
                mazeWidth = mazeRow.length();
            }
            for (int colX = 0; colX < mazeWidth; colX++) {
                if (mazeRow.charAt(colX) == 'S') {
                    startY = mazeHeight;
                    startX = colX;
                } else if (mazeRow.charAt(colX) == 'F') {
                    finishY = mazeHeight;
                    finishX = colX;
                }
            }
            mazeHeight++;
        }

        String[][] mazeArray = new String[mazeHeight][mazeWidth];
        bufferedReader = new BufferedReader(new FileReader(fileName));
        int rowY = 0;
        while ((mazeRow = bufferedReader.readLine()) != null) {
            for (int colX = 0; colX < mazeWidth; colX++) {
                mazeArray[rowY][colX] = String.valueOf(mazeRow.charAt(colX));
            }
            rowY++;
        }

        return new Maze(mazeArray, startY, startX, finishY, finishX);
    }
}