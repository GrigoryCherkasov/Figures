import javax.swing.*;
import java.awt.*;

public class Triangle extends AbstractButton{
    private Color color;

    Triangle(int x, int y, int size, Color color) {
        super();
        setBounds(x, y, size, size);
        this.color = color;
    }

    protected void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillPolygon(new int[] {0, 0, getBounds().width}, new int[] {0, getBounds().height, getBounds().height}, 3);
    }
}
