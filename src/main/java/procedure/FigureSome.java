package procedure;

import CommonObjects.PaintCanvasStruct;
import CommonObjects.PaintWindowStruct;

import java.awt.*;

public class FigureSome extends PaintWindowStruct {
    int step = 0;

    int[][] squaresCoordinates = {
            {50, 50, 40, 2, 3, 0x0000ffff},
            {200, 150, 50, 1, 1, 0x0000ff00}
    };
    int[][] circlesCoordinates = {
            {110, 120, 30, 1, 2, 0x00ff0000},
            {90, 60, 45, 2, 2, 0x00ffff00}
    };
    int[][] trianglesCoordinates = {
            {40, 30, 55, 80, 90, 70, 3, 2, 0x000000ff},
            {200, 250, 240, 180, 270, 220, 2, 1, 0x00ff00ff}
    };

    @Override
    public void paint(PaintCanvasStruct g) {

        for (int i = 0; i < squaresCoordinates.length; i++) {
            int[] square = squaresCoordinates[i];

            g.fillRect(square[0], square[1], square[2], square[2], new Color(square[5]));

            square[0] += square[3];
            square[1] += square[4];

            if (square[0] <= 0 || square[0] + square[2] >= getCanvasWith()) {
                square[3] = -square[3];
            }
            if (square[1] <= 0 || square[1] + square[2] >= getCanvasHeight()) {
                square[4] = -square[4];
            }

        }

        for (int i = 0; i < circlesCoordinates.length; i++) {
            int[] circle = circlesCoordinates[i];

            g.fillOval(circle[0], circle[1], circle[2], new Color(circle[5]));

            circle[0] += circle[3];
            circle[1] += circle[4];

            if (circle[0] - circle[2] <= 0 || circle[0] + circle[2] >= getCanvasWith()) {
                circle[3] = -circle[3];
            }
            if (circle[1] - circle[2] <= 0 || circle[1] + circle[2] >= getCanvasHeight()) {
                circle[4] = -circle[4];
            }

        }

        for (int i = 0; i < trianglesCoordinates.length; i++) {
            int[] triangle = trianglesCoordinates[i];

            g.fillTriangle(triangle[0], triangle[1], triangle[2], triangle[3], triangle[4], triangle[5],
                    new Color(triangle[8]));
            triangle[0] += triangle[6];
            triangle[2] += triangle[6];
            triangle[4] += triangle[6];

            triangle[1] += triangle[7];
            triangle[3] += triangle[7];
            triangle[5] += triangle[7];

            int xMin = Math.min(Math.min(triangle[0], triangle[2]), triangle[4]);
            int xMax = Math.max(Math.max(triangle[0], triangle[2]), triangle[4]);
            int yMin = Math.min(Math.min(triangle[1], triangle[3]), triangle[5]);
            int yMax = Math.max(Math.max(triangle[1], triangle[3]), triangle[5]);

            if (xMin <= 0 || xMax >= getCanvasWith()) {
                triangle[6] = -triangle[6];
            }
            if (yMin <= 0 || yMax >= getCanvasHeight()) {
                triangle[7] = -triangle[7];
            }

        }

        for (int i = 0; i < circlesCoordinates.length; i++) {
            if(step % 10 == 0) {
                circlesCoordinates[i][5] = (int) (Math.random() * 0x1000000);
                step = 0;
            }
        }
        step++;

    }


    public static void main(String[] args) throws InterruptedException {

        PaintWindowStruct paintWindow = new FigureSome();
        paintWindow.setVisible(true);

        while (true) {
            paintWindow.repaint();
            Thread.sleep(10);
        }
    }
}