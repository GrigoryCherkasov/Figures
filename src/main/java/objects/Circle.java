package objects;

import java.awt.Color;

public class Circle extends Figure{

    private final Point center;
    private final int radius;

    Circle(Point center, int radius, Distance distance, Color color) {
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
        checkRange(new Point(center.x - radius, center.y  - radius),
                new Point(center.x + radius, center.y  + radius));
    }

    @Override
    public void changeColor() {
        if(step % 10 == 0) {
            color = new Color((int)(Math.random() * 0x1000000));
            step = 0;
        }
        step++;
    };
}
