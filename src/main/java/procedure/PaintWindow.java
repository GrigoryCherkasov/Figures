package procedure;

import javax.swing.*;
import java.awt.*;

public class PaintWindow extends JFrame {
    PaintCanvas canvas;

    public PaintWindow(){
        this(500, 500);
    }

    public PaintWindow(int width, int height){
        canvas = new PaintCanvas();
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

    public int getCanvasWith(){
        return getContentPane().getWidth();
    }

    public int getCanvasHeight(){
        return getContentPane().getHeight();
    }

    public void paint(PaintCanvas g){}
}
