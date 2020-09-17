package objects;

import javax.swing.*;
import java.awt.*;

public abstract class Figure extends JComponent{
    protected Point distance;
    protected Color color;

    protected Figure(Point distance, Color color){
        this.distance = distance;
        this.color = color;
    }

    public abstract void move(JFrame frame);

    public void checkRange(Point minPoint, Point maxPoint, Point distance, JFrame frame) {

        if(minPoint.x  <= 0 || maxPoint.x >= frame.getContentPane().getWidth()){
            distance.reverceX();
        }
        if(minPoint.y <= 0 || maxPoint.y >= frame.getContentPane().getHeight()){
            distance.reverceY();
        }
    }
}
