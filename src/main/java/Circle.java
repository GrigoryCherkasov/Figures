import javax.swing.*;
import java.awt.*;

public class Circle extends AbstractButton{
    private Color color;

    Circle(int x, int y, int size, Color color) {
        super();
        setBounds(x, y, size, size);
        this.color = color;
        }

    protected void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillOval(0, 0, getSize().width-1 ,getSize().height-1 );
    }
}
