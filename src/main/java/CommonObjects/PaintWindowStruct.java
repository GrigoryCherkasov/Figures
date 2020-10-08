package CommonObjects;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Graphics;

public class PaintWindowStruct extends JFrame {
    PaintCanvasStruct canvas;

    public PaintWindowStruct() {
        this(500, 500);
    }

    public PaintWindowStruct(int width, int height) {
        canvas = new PaintCanvasStruct();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(width, height));
        setLayout(null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        canvas.setGraphics(g);
        canvas.setInsets(getInsets());
        paint(canvas);
    }

    public int getCanvasWith() {
        return getContentPane().getWidth();
    }

    public int getCanvasHeight() {
        return getContentPane().getHeight();
    }

    public void paint(PaintCanvasStruct g) {
    }
}
