package procedure;

import javax.swing.*;
import java.awt.*;

public class Circle extends AbstractButton{
    private Color color;
    private int radius;

    Circle(int x, int y, int radius, int color) {
        super();
        setBounds(x - radius, y - radius, radius * 2, radius * 2);
        this.radius = radius;
        this.color = new Color(color);
        }

    protected void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillOval(0, 0, getSize().width-1 ,getSize().height-1 );
    }

    public void setLocation(int x, int y) {
        super.setLocation(x- radius, y - radius);
    }
}
