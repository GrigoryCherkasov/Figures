package procedure;

import java.awt.*;

public class Figure extends PaintWindow{

    int xq = 30;
    int yq = 50;
    int sizeq = 40;
    int dxq = 2;
    int dyq = 3;

    int xc = 110;
    int yc = 120;
    int radiusc = 30;
    int dxc = 1;
    int dyc = 2;

    int x1 = 40;
    int y1 = 30;
    int x2 = 55;
    int y2 = 80;
    int x3 = 90;
    int y3 = 70;
    int dxt = 3;
    int dyt = 2;

    @Override
    public void paint(PaintCanvas g) {

        g.fillRect(xq, yq, sizeq, sizeq, Color.GREEN);

        xq += dxq;
        yq += dyq;

        if(xq  <= 0 || xq + sizeq >= getCanvasWith()){
            dxq = -dxq;
        }
        if(yq <= 0 || yq + sizeq >= getCanvasHeight()){
            dyq = -dyq;
        }

        g.fillOval(xc, yc, radiusc, Color.RED);

        xc += dxc;
        yc += dyc;

        if(xc - radiusc  <= 0 || xc + radiusc >= getCanvasWith()){
            dxc = -dxc;
        }
        if(yc - radiusc <= 0 || yc + radiusc >= getCanvasHeight()){
            dyc = -dyc;
        }

        g.fillTriangle(x1, y1, x2, y2, x3, y3, Color.YELLOW);
        x1 += dxt;
        y1 += dyt;
        x2 += dxt;
        y2 += dyt;
        x3 += dxt;
        y3 += dyt;

        int xMin = Math.min(Math.min(x1, x2), x3);
        int xMax = Math.max(Math.max(x1, x2), x3);
        int yMin = Math.min(Math.min(y1, y2), y3);
        int yMax = Math.max(Math.max(y1, y2), y3);

        if(xMin  <= 0 || xMax >= getCanvasWith()){
            dxt = -dxt;
        }
        if(yMin <= 0 || yMax >= getCanvasHeight()){
            dyt = -dyt;
        }
    }


    public static void main(String[] args) throws InterruptedException {

        PaintWindow paintWindow = new Figure();
        paintWindow.setVisible(true);

        while (true) {
            paintWindow.repaint();
            Thread.sleep(10);
        }
    }
}