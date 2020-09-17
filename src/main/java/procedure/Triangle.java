package procedure;

import javax.swing.*;
import java.awt.*;

public class Triangle extends JComponent{
    private Color color;
    int x1, y1, x2, y2, x3, y3;
    private int xMin, yMin;

    Triangle(int x1, int y1, int x2, int y2, int x3, int y3, int color) {
        super();
        this.xMin = Math.min(Math.min(x1, x2), x3);
        int xMax = Math.max(Math.max(x1, x2), x3);
        this.yMin = Math.min(Math.min(y1, y2), y3);
        int yMax = Math.max(Math.max(y1, y2), y3);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;

        setBounds(xMin, yMin, xMax - xMin, yMax - yMin);
        this.color = new Color(color);
    }

    protected void paintComponent(Graphics g) {
        g.setColor(color);
        //g.fillPolygon(new int[] {0, 0, getBounds().width}, new int[] {0, getBounds().height, getBounds().height}, 3);
        g.fillPolygon(new int[] {x1 - xMin, x2 - xMin, x3 - xMin},
                new int[] {y1 - yMin, y2 - yMin, y3 - yMin}, 3);
    }

    public void setLocation(int x, int y) {
        int dx = x - this.x1;
        int dy = y - this.y1;
        super.setLocation(xMin + dx, yMin + dy);
    }
}
