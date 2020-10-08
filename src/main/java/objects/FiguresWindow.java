package objects;

import CommonObjects.PaintCanvas;
import CommonObjects.PaintWindow;

public class FiguresWindow extends PaintWindow {

    public FiguresWindow(int width, int height) {
        super(width, height);
    }

    @Override
    public void paintCanvas(PaintCanvas canvas) {
        for(Figure figure: canvas.getFigures()){
            figure.draw();
            figure.move();
            figure.checkBorder();
        }
    }
}
