package procedure;

import CommonObjects.PaintCanvasStruct;
import CommonObjects.PaintWindowStruct;

import java.awt.*;

public class FigureProc extends PaintWindowStruct {

    private static final int CIRCLE = 0;
    private static final int SQUARE = 1;
    private static final int TRIANGLE = 2;

    int[][][] circlesCoordinates = {{{110, 120}, {30}, {1, 2}, {0x00ff0000}}, {{90, 60}, {45}, {2, 2}, {0x00ffff00}}};
    int[][][] squaresCoordinates = {{{30, 50}, {40}, {2, 3}, {0x0000ffff}}, {{200, 150}, {50}, {1, 1}, {0x0000ff00}}};
    int[][][] trianglesCoordinates = {{{40, 30, 55, 80, 90, 70}, {}, {3, 2}, {0x000000ff}}, {{200, 250, 240, 180, 270, 220}, {}, {2, 1}, {0x00ff00ff}}};

    @Override
    public void paint(PaintCanvasStruct g) {
        moveFigures(circlesCoordinates, CIRCLE, g);
        moveFigures(squaresCoordinates, SQUARE, g);
        moveFigures(trianglesCoordinates, TRIANGLE, g);
    }

    private void moveFigures(int[][][] figures, int type, PaintCanvasStruct g){
        for(int i = 0; i < figures.length; i++){
            moveFigure(figures[i], type, g);
        }
    }

    private void moveFigure(int[][] figure, int type, PaintCanvasStruct g) {
        drawFigure(figure[0], figure[1], new Color(figure[3][0]), type, g);
        move(figure[0], figure[2]);
        checkBorders(figure[0], figure[1], figure[2], type);
    }

    private void drawFigure(int[] coordinates, int[] size, Color color, int type, PaintCanvasStruct g){
        if (type == CIRCLE){
            g.fillOval(coordinates[0], coordinates[1], size[0], color);
        } else if (type == SQUARE){
            g.fillRect(coordinates[0], coordinates[1], size[0], size[0], color);
        } else {
            g.fillTriangle(coordinates[0], coordinates[1], coordinates[2], coordinates[3], coordinates[4], coordinates[5],
                    color);
        }
    }

    private void move(int[] coordinates, int[] increment){
        for (int i = 0; i < coordinates.length; i += 2){
            coordinates[i] += increment[0];
        }

        for (int i = 1; i < coordinates.length; i += 2){
            coordinates[i] += increment[1];
        }
    }

    private void checkBorders(int[] coordinates, int[] size, int[] increment, int type){
        int xMin;
        int xMax;
        int yMin;
        int yMax;

        if (type == CIRCLE){
            xMin = coordinates[0] - size[0];
            xMax = coordinates[0] + size[0];
            yMin = coordinates[1] - size[0];
            yMax = coordinates[1] + size[0];
        } else if (type == SQUARE){
            xMin = coordinates[0];
            xMax = coordinates[0] + size[0];
            yMin = coordinates[1];
            yMax = coordinates[1] + size[0];

        } else {
            xMin = Math.min(Math.min(coordinates[0], coordinates[2]), coordinates[4]);
            xMax = Math.max(Math.max(coordinates[0], coordinates[2]), coordinates[4]);
            yMin = Math.min(Math.min(coordinates[1], coordinates[3]), coordinates[5]);
            yMax = Math.max(Math.max(coordinates[1], coordinates[3]), coordinates[5]);

        }
        if(xMin  <= 0 || xMax >= getCanvasWith()){
            increment[0] = -increment[0];
        }
        if(yMin <= 0 || yMax >= getCanvasHeight()){
            increment[1] = -increment[1];
        }
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