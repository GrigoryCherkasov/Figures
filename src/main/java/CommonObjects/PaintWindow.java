package CommonObjects;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Graphics;

public abstract class PaintWindow extends JFrame {
    PaintCanvas canvas;


    public PaintWindow(int width, int height) {
        canvas = new PaintCanvas();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(width, height));
        setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        canvas.setGraphics(g);
        canvas.setInsets(getInsets());
        canvas.setWidth(getContentPane().getWidth());
        canvas.setHeight(getContentPane().getHeight());
        paintCanvas(canvas);
    }


    public PaintCanvas getPaintCanvas() {
        return canvas;
    }

    public abstract void paintCanvas(PaintCanvas canvas);
}
