package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import java.util.Random;

public class Triangle extends Figure {
    private Point vertex1, vertex2, vertex3;
    private Point maxPoint, minPoint;

    public Triangle(Point vertex1, Point vertex2, Point vertex3, Color color, Point distance) {
        super(distance, color);
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;

        this.maxPoint = new Point(Math.max(Math.max(vertex1.x, vertex2.x), vertex3.x),
                Math.max(Math.max(vertex1.y, vertex2.y), vertex3.y));
        this.minPoint = new Point(Math.min(Math.min(vertex1.x, vertex2.x), vertex3.x),
                Math.min(Math.min(vertex1.y, vertex2.y), vertex3.y));

        setBounds(minPoint.x, minPoint.y, maxPoint.x - minPoint.x, maxPoint.y - minPoint.y);
    }

    protected void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillPolygon(new int[] {vertex1.x - minPoint.x, vertex2.x - minPoint.x, vertex3.x - minPoint.x},
                new int[] {vertex1.y - minPoint.y, vertex2.y - minPoint.y, vertex3.y - minPoint.y}, 3);
    }

    public void move() {
        vertex1.move(distance);
        vertex2.move(distance);
        vertex3.move(distance);
        minPoint.move(distance);
        maxPoint.move(distance);

        setLocation(minPoint.x, minPoint.y);

        checkRange(minPoint, maxPoint, distance);
    }

    public static Figure createRandomFigure(Container container){
        Random random = new Random();
        int ratio = random.nextInt(3) + 2;
        int containerWidth = container.getWidth();
        int containerHeight = container.getHeight();

        int xSize = (50 + random.nextInt(containerWidth - 50)) / ratio;
        int ySize = (100 + random.nextInt(containerHeight - 100)) / ratio;

        Point vert1 = new Point(0, random.nextInt(ySize));
        Point vert2 = new Point(xSize/2 + random.nextInt(xSize / 2), 0);
        Point vert3 = new Point(xSize/2 + random.nextInt(xSize / 2),  ySize);

        Point distance = new Point(random.nextInt(2) + 1,
                random.nextInt(2) + 1);

        return new Triangle(vert1, vert2, vert3, getRandomColor(), distance);
    }

}
