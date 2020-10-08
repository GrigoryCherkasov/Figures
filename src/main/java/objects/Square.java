package objects;

import java.awt.*;

public class Square extends Figure{

    private final Point corner;
    private final int size;

    Square(Point corner, int size, Point distance, Color color) {
        super(distance, color);
        this.corner = corner;
        this.size = size;
    }

    @Override
    public void draw() {
        canvas.fillRect(corner.x, corner.y, size , size, color);
    }

    @Override
    public void move() { corner.movePoint(distance); }

    @Override
    public void checkBorder() {
        checkRange(corner, corner.pointIn(size), distance);
    }
}
