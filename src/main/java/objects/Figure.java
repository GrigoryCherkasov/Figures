package objects;

import CommonObjects.PaintCanvas;

import java.awt.Color;

public abstract class Figure{
    protected Point distance;
    protected Color color;
    protected PaintCanvas canvas;

    protected Figure(Point distance, Color color){
        this.distance = distance;
        this.color = color;
    }

    public void setCanvas(PaintCanvas canvas) {
        this.canvas = canvas;
    }

    protected void checkRange(Point minPoint, Point maxPoint, Point distance) {
        if(minPoint.x  <= 0 || maxPoint.x >= canvas.getWidth()){
            distance.reverceX();
        }
        if(minPoint.y <= 0 || maxPoint.y >= canvas.getHeight()){
            distance.reverceY();
        }
    }

    public abstract void draw();

    public abstract void move();

    public abstract void checkBorder();
}
