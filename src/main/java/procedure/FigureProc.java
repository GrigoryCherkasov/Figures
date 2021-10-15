package procedure;

import CommonObjects.PaintCanvasStruct;
import CommonObjects.PaintWindowStruct;

import java.awt.*;

public class FigureProc extends PaintWindowStruct {

    int stepCircle = 0;
    int stepTriangle = 0;

    int[][][] circlesCoordinates = {
            {
                {110, 120}, {30}, {1, 2}, {0x00ff0000}
            }, {
                {90, 60}, {45}, {2, 2}, {0x00ffff00}
            }
    };

    int[][][] squaresCoordinates = {
            {
                {50, 50}, {40}, {2, 3}, {0x0000ffff}
            }, {
                {200, 150}, {50}, {1, 1}, {0x0000ff00}
            }
    };
    int[][][] trianglesCoordinates = {
            {
                {40, 30, 55, 80, 90, 70}, {3, 2}, {0x000000ff}
            }, {
                {200, 250, 240, 180, 270, 220}, {2, 1}, {0x00ff00ff}
            }
    };

    @Override
    public void paint(PaintCanvasStruct g) {
        paintCircle(circlesCoordinates, g);
        paintSquares(squaresCoordinates, g);
        paintTriangles(trianglesCoordinates, g);
        changeCircleColor(circlesCoordinates);
        changeTrianglesColor(trianglesCoordinates);
    }

    private void paintCircle(int[][][] circles, PaintCanvasStruct g) {
        for (int i = 0; i < circles.length; i++) {
            g.fillOval(circles[i][0][0], circles[i][0][1], circles[i][1][0], new Color(circles[i][3][0]));
            move(circles[i][0], circles[i][2]);
            checkBordersCircle(circles[i][0], circles[i][1], circles[i][2]);
        }
    }

    private void paintSquares(int[][][] squares, PaintCanvasStruct g) {
        for (int i = 0; i < squares.length; i++) {
            g.fillRect(squares[i][0][0], squares[i][0][1], squares[i][1][0], squares[i][1][0], new Color(squares[i][3][0]));
            move(squares[i][0], squares[i][2]);
            checkBordersSquares(squares[i][0], squares[i][1], squares[i][2]);
        }
    }

    private void paintTriangles(int[][][] triangles, PaintCanvasStruct g) {
        for (int i = 0; i < triangles.length; i++) {
            g.fillTriangle(triangles[i][0][0], triangles[i][0][1], triangles[i][0][2], triangles[i][0][3], triangles[i][0][4], triangles[i][0][5], new Color(triangles[i][2][0]));
            move(triangles[i][0], triangles[i][1]);
            checkBordersTriangles(triangles[i][0], triangles[i][1]);
        }
    }

    private void move(int[] coordinates, int[] increment) {
        for (int i = 0; i < coordinates.length; i += 2) {
            coordinates[i] += increment[0];
            coordinates[i + 1] += increment[1];
        }
    }

    private void checkBordersCircle(int[] coordinates, int[] size, int[] increment) {
        int xMin = coordinates[0] - size[0];
        int xMax = coordinates[0] + size[0];
        int yMin = coordinates[1] - size[0];
        int yMax = coordinates[1] + size[0];

        checkDirection(xMin, xMax, yMin, yMax, increment);
    }
    private void checkBordersSquares(int[] coordinates, int[] size, int[] increment) {
        int xMin = coordinates[0];
        int xMax = coordinates[0] + size[0];
        int yMin = coordinates[1];
        int yMax = coordinates[1] + size[0];

        checkDirection(xMin, xMax, yMin, yMax, increment);
    }
    private void checkBordersTriangles(int[] coordinates, int[] increment) {
        int xMin = Math.min(Math.min(coordinates[0], coordinates[2]), coordinates[4]);
        int xMax = Math.max(Math.max(coordinates[0], coordinates[2]), coordinates[4]);
        int yMin = Math.min(Math.min(coordinates[1], coordinates[3]), coordinates[5]);
        int yMax = Math.max(Math.max(coordinates[1], coordinates[3]), coordinates[5]);

        checkDirection(xMin, xMax, yMin, yMax, increment);
    }

    private void checkDirection(int xMin, int xMax, int yMin, int yMax, int[] increment) {

        if (xMin <= 0 || xMax >= getCanvasWith()) {
            increment[0] = -increment[0];
        }

        if (yMin <= 0 || yMax >= getCanvasHeight()) {
            increment[1] = -increment[1];
        }
    }

    private void changeCircleColor(int[][][] figures) {
        for (int i = 0; i < figures.length; i++) {
            if(stepCircle % 10 == 0) {
                figures[i][3][0] = (int) (Math.random() * 0x1000000);
                stepCircle = 0;
            }
        }
        stepCircle++;
    }
    private void changeTrianglesColor(int[][][] figures) {
        for (int i = 0; i < figures.length; i++) {
            if(stepTriangle % 20 == 0) {
                figures[i][2][0] = ~figures[i][2][0];
                stepTriangle = 0;
            }
        }
        stepTriangle++;
    }



    public static void main(String[] args) throws InterruptedException {

        PaintWindowStruct paintWindow = new FigureProc();
        paintWindow.setVisible(true);

        while (true) {
            paintWindow.repaint();
            Thread.sleep(10);
        }
    }
}