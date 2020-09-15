package objects;

import javax.swing.*;
import java.awt.*;

public class Triangle extends Figure{
    private Point vertex1, vertex2, vertex3;
    private Point maxPoint, minPoint;

    Triangle(Point vertex1, Point vertex2, Point vertex3, Color color, Point distance) {
        super();
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
        this.distance = distance;

        this.maxPoint = new Point(Math.max(Math.max(vertex1.x, vertex2.x), vertex3.x),
                Math.max(Math.max(vertex1.y, vertex2.y), vertex3.y));
        this.minPoint = new Point(Math.min(Math.min(vertex1.x, vertex2.x), vertex3.x),
                Math.min(Math.min(vertex1.y, vertex2.y), vertex3.y));

        setBounds(minPoint.x, minPoint.y, maxPoint.x - minPoint.x, maxPoint.y - minPoint.y);
        this.color = color;
    }

    protected void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillPolygon(new int[] {vertex1.x - minPoint.x, vertex2.x - minPoint.x, vertex3.x - minPoint.x},
                new int[] {vertex1.y - minPoint.y, vertex2.y - minPoint.y, vertex3.y - minPoint.y}, 3);
    }

    public void move(JFrame frame) {
        vertex1.move(distance);
        vertex2.move(distance);
        vertex3.move(distance);
        minPoint.move(distance);
        maxPoint.move(distance);

        setLocation(minPoint.x, minPoint.y);

        if(minPoint.x  <= 0 || maxPoint.x >= frame.getContentPane().getWidth()){
            distance.reverceX();
        }
        if(minPoint.y <= 0 || maxPoint.y >= frame.getContentPane().getHeight()){
            distance.reverceY();
        }
    }
}
