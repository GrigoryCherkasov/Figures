package CommonObjects;

import java.awt.Color;
import java.awt.Insets;
import java.awt.Graphics;

public class PaintCanvasStruct {
    private Graphics g;
    private Insets insets;

    public PaintCanvasStruct() {
    }

    public void setGraphics(Graphics g) {
        this.g = g;
    }

    public void setInsets(Insets insets) {
        this.insets = insets;
    }

    public void setColor(Color color) {
        g.setColor(color);
    }

    public void fillRect(int x, int y, int width, int height, Color color) {
        g.setColor(color);
        g.fillRect(x + insets.left, y + insets.top, width, height);
    }

    public void fillOval(int x, int y, int radius, Color color) {
        g.setColor(color);
        g.fillOval(x + insets.left - radius, y + insets.top - radius, radius * 2, radius * 2);
    }

    public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3, Color color) {
        g.setColor(color);

        g.fillPolygon(new int[]{x1 + insets.left, x2 + insets.left, x3 + insets.left},
                new int[]{y1 + insets.top, y2 + insets.top, y3 + insets.top}, 3);

    }
}
