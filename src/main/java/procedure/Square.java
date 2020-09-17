package procedure;

import javax.swing.*;
import java.awt.*;

public class Square extends JComponent{
    private Color color;

    Square(int x, int y, int size, int color) {
        super();
        setBounds(x, y, size, size);
        this.color = new Color(color);
    }

    protected void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillRect(0, 0, getSize().width-1 ,getSize().height-1 );
    }
}
