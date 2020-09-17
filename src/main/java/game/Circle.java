package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import java.util.Random;

public class Circle extends Figure {

    private Point center;
    private int radius;

    Circle(Point center, int radius, Color color, Point distance) {
        super(distance, color);
        this.center = center;
        this.radius = radius;
        setBounds(center.x - radius, center.y - radius, radius * 2, radius * 2);
    }

    protected void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillOval(0, 0, getSize().width-1 ,getSize().height-1 );
    }

    public void move() {
        center.move(distance);
        setLocation(center.x - radius, center.y - radius);
        checkRange(center.getDistancePoint(- radius),center.getDistancePoint(radius), distance);
    }

    public static Figure createRandomFigure(Container container){
        Random random = new Random();
        int ratio = random.nextInt(7) + 5;
        int containerWidth = container.getWidth();
        int containerHeight = container.getHeight();

        int radius = Math.min(containerWidth / ratio, containerHeight / ratio);
        Point center = new Point(random.nextInt(containerWidth - 2 * radius) + radius,
                random.nextInt(containerHeight - 2 * radius) + radius);
        Point distance = new Point(random.nextInt(2) + 1,
                random.nextInt(2) + 1);

        return new Circle(center, radius, getRandomColor(), distance);
    }
}
