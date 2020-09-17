package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import java.util.Random;

public class Square extends Figure {

    private Point corner;
    private int size;

    public Square(Point corner, int size, Color color, Point distance) {
        super(distance, color);
        this.corner = corner;
        this.size = size;
        setBounds(corner.x, corner.y, size, size);
    }

    protected void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillRect(0, 0, getSize().width-1 ,getSize().height-1 );
    }

    public void move() {
        corner.move(distance);
        setLocation(corner.x, corner.y);
        checkRange(corner, corner.getDistancePoint(size), distance);
    }

    public static Figure createRandomFigure(Container container){
        Random random = new Random();
        int ratio = random.nextInt(5) + 4;
        int containerWidth = container.getWidth();
        int containerHeight = container.getHeight();

        int size = Math.min(containerWidth / ratio, containerHeight / ratio);

        Point corner = new Point(random.nextInt(containerWidth - size),
                random.nextInt(containerHeight - size));
        Point distance = new Point(random.nextInt(2) + 1,
                random.nextInt(2) + 1);

        return new Square(corner, size, getRandomColor(), distance);
    }

}
