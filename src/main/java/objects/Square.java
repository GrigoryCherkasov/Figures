package objects;

import javax.swing.*;
import java.awt.*;

public class Square extends Figure{

    private Point corner;
    private int size;

    Square(Point corner, int size, Color color, Point distance) {
        super(distance, color);
        this.corner = corner;
        this.size = size;
        setBounds(corner.x, corner.y, size, size);
    }

    protected void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillRect(0, 0, getSize().width-1 ,getSize().height-1 );
    }

    public void move(JFrame frame) {
        corner.move(distance);
        setLocation(corner.x, corner.y);
        checkRange(corner, corner.getDistancePoint(size), distance, frame);
    }
}
