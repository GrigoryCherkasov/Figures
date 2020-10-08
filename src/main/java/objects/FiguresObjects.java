package objects;

import CommonObjects.PaintCanvas;
import java.awt.Color;

public class FiguresObjects {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    public static void main(String[] args) throws InterruptedException {

        FiguresWindow figuresWindow = new FiguresWindow(WIDTH, HEIGHT);

        PaintCanvas canvas = figuresWindow.getPaintCanvas();
        canvas.addFigure(new Circle(new Point(110, 120), 50, new Point(1, 2), Color.RED));
        canvas.addFigure(new Circle(new Point(90, 60), 30, new Point(2, 2), Color.YELLOW));
        canvas.addFigure(new Square(new Point(30, 50), 40, new Point(2, 3), Color.GREEN));
        canvas.addFigure(new Square(new Point(200, 150), 50, new Point(1, 1), Color.GRAY));
        canvas.addFigure(new Triangle(new Point(40, 30), new Point(55, 80), new Point(90, 70),
                new Point(3, 2), Color.BLUE));
        canvas.addFigure(new Triangle(new Point(200, 250), new Point(240, 180), new Point(270, 220),
                new Point(2, 1), Color.MAGENTA));

        figuresWindow.setVisible(true);

        while (true) {
            figuresWindow.repaint();
            Thread.sleep(10);
        }
    }
}