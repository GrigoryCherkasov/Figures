package objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Circle extends Figure{

    private Point center;
    private int radius;

    Circle(Point center, int radius, Color color, Point distance) {
        super(distance, color);
        this.center = center;
        this.radius = radius;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("X=" + e.getX() + " Y=" + e.getY());
            }
        });
        setBounds(center.x - radius, center.y - radius, radius * 2, radius * 2);
    }

    protected void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillOval(0, 0, getSize().width-1 ,getSize().height-1 );
    }

    public void move(JFrame frame) {
        center.move(distance);
        setLocation(center.x - radius, center.y - radius);
        checkRange(center.getDistancePoint(- radius),center.getDistancePoint(radius), distance, frame);
    }
}
