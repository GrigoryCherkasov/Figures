package objects;

import CommonObjects.PaintCanvas;

import java.awt.Color;

public abstract class Figure{
    protected Distance distance;
    protected Color color;
    protected PaintCanvas canvas;
    protected int step = 0;

    protected Figure(Distance distance, Color color){
        this.distance = distance;
        this.color = color;
    }
    public abstract void draw();

    public abstract void move();

    public abstract void checkBorder();

    protected void checkRange(Point minPoint, Point maxPoint) {
        if(minPoint.x  <= 0 || maxPoint.x >= canvas.getWidth()){
            distance.reverceX();
        }
        if(minPoint.y <= 0 || maxPoint.y >= canvas.getHeight()){
            distance.reverceY();
        }
    }

    public void changeColor() {};


    public void setCanvas(PaintCanvas canvas) {
        this.canvas = canvas;
    }

}
