package objects;

import javax.swing.*;
import java.awt.*;

public class Square extends Figure{

    private Point corner;
    private int size;

    Square(Point corner, int size, Color color, Point distance) {
        super();
        setBounds(corner.x, corner.y, size, size);

        this.corner = corner;
        this.distance = distance;
        this.size = size;
        this.color = color;
    }

    protected void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillRect(0, 0, getSize().width-1 ,getSize().height-1 );
    }

    public void move(JFrame frame) {
        corner.move(distance);
        setLocation(corner.x, corner.y);

        if(corner.x  <= 0 || corner.x + size >= frame.getContentPane().getWidth()){
            distance.reverceX();
        }
        if(corner.y <= 0 || corner.y + size >= frame.getContentPane().getHeight()){
            distance.reverceY();
        }
    }
}
