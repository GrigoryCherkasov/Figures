package procedure;

import CommonObjects.PaintCanvas;
import CommonObjects.PaintWindow;

import java.awt.*;

public class Figure extends PaintWindow {

    int xq = 30;
    int yq = 50;
    int sizeq = 40;
    int dxq = 2;
    int dyq = 3;

    int xc = 110;
    int yc = 120;
    int rc = 30;
    int dxc = 1;
    int dyc = 2;

    int xt1 = 40;
    int yt1 = 30;
    int xt2 = 55;
    int yt2 = 80;
    int xt3 = 90;
    int yt3 = 70;
    int dxt = 3;
    int dyt = 2;

    @Override
    public void paintCanvas(PaintCanvas g) {

        g.fillRect(xq, yq, sizeq, sizeq, Color.GREEN);

        xq += dxq;
        yq += dyq;

        if (xq <= 0 || xq + sizeq >= getCanvasWith()) {
            dxq = -dxq;
        }
        if (yq <= 0 || yq + sizeq >= getCanvasHeight()) {
            dyq = -dyq;
        }

        g.fillOval(xc, yc, rc, Color.RED);

        xc += dxc;
        yc += dyc;

        if (xc - rc <= 0 || xc + rc >= getCanvasWith()) {
            dxc = -dxc;
        }
        if (yc - rc <= 0 || yc + rc >= getCanvasHeight()) {
            dyc = -dyc;
        }

        g.fillTriangle(xt1, yt1, xt2, yt2, xt3, yt3, Color.YELLOW);
        xt1 += dxt;
        yt1 += dyt;
        xt2 += dxt;
        yt2 += dyt;
        xt3 += dxt;
        yt3 += dyt;

        int xMin = Math.min(Math.min(xt1, xt2), xt3);
        int xMax = Math.max(Math.max(xt1, xt2), xt3);
        int yMin = Math.min(Math.min(yt1, yt2), yt3);
        int yMax = Math.max(Math.max(yt1, yt2), yt3);

        if (xMin <= 0 || xMax >= getCanvasWith()) {
            dxt = -dxt;
        }
        if (yMin <= 0 || yMax >= getCanvasHeight()) {
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