package objects;

import java.awt.Color;

public class Circle extends Figure{

    private final Point center;
    private final int radius;

    Circle(Point center, int radius, Point distance, Color color) {
        super(distance, color);
        this.center = center;
        this.radius = radius;
    }

    @Override
    public void draw() {
        canvas.fillOval(center.x, center.y, radius, color);
    }

    @Override
    public void move() {
        center.movePoint(distance);
    }

    @Override
    public void checkBorder() {
        checkRange(center.pointIn(-radius), center.pointIn(radius), distance);
    }
}
