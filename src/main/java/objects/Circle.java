package objects;

import javax.swing.*;
import java.awt.*;

public class Circle extends Figure{

    private Point center;
    private int radius;

    Circle(Point center, int radius, Color color, Point distance) {
        super();
        setBounds(center.x - radius, center.y - radius, radius * 2, radius * 2);
        this.center = center;
        this.distance = distance;
        this.radius = radius;
        this.color = color;
        }

    protected void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillOval(0, 0, getSize().width-1 ,getSize().height-1 );
    }

    public void move(JFrame frame) {
        center.move(distance);
        setLocation(center.x - radius, center.y - radius);

        if(center.x - radius  <= 0 || center.x + radius >= frame.getContentPane().getWidth()){
            distance.reverceX();
        }
        if(center.y - radius <= 0 || center.y + radius >= frame.getContentPane().getHeight()){
            distance.reverceY();
        }
    }
}
