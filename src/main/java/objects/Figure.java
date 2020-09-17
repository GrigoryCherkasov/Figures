package objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class Figure extends JComponent{
    protected Point distance;
    protected Color color;
    private final JComponent thisComponent;

    protected Figure(Point distance, Color color){
        this.distance = distance;
        this.color = color;
        thisComponent = this;
    }

    public abstract void move();

    public void checkRange(Point minPoint, Point maxPoint, Point distance) {

        if(minPoint.x  <= 0 || maxPoint.x >= getParent().getWidth()){
            distance.reverceX();
        }
        if(minPoint.y <= 0 || maxPoint.y >= getParent().getHeight()){
            distance.reverceY();
        }
    }
}
