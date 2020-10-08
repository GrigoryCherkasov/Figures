package objects;

import java.awt.Color;

public class Triangle extends Figure{
    private final Point vertex1, vertex2, vertex3;

    Triangle(Point vertex1, Point vertex2, Point vertex3, Point distance, Color color) {
        super(distance, color);
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
    }

    @Override
    public void draw() {
        canvas.fillTriangle(vertex1.x, vertex1.y, vertex2.x, vertex2.y, vertex3.x, vertex3.y, color);
    }

    @Override
    public void move() {
        vertex1.movePoint(distance);
        vertex2.movePoint(distance);
        vertex3.movePoint(distance);
    }

    @Override
    public void checkBorder() {
        Point minPoint = new Point(Math.min(Math.min(vertex1.x, vertex2.x), vertex3.x),
                Math.min(Math.min(vertex1.y, vertex2.y), vertex3.y));

        Point maxPoint = new Point(Math.max(Math.max(vertex1.x, vertex2.x), vertex3.x),
                Math.max(Math.max(vertex1.y, vertex2.y), vertex3.y));

        checkRange(minPoint, maxPoint, distance);
    }
}
