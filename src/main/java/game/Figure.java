package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class Figure extends JComponent{
    protected Point distance;
    protected Color color;
    private final JComponent thisComponent;

    protected Figure(Point distance, Color color){
        this.distance = distance;
        this.color = color;
        thisComponent = this;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Container container = getParent();
                container.remove(thisComponent);
                container.repaint();
            }
        });
    }

    public abstract void move();

    protected static Color getRandomColor(){
        return new Color((int)(Math.random() * 0x1000000));
    }

    public void checkRange(Point minPoint, Point maxPoint, Point distance) {
        if (getParent() != null) {
            if (minPoint.x <= 0 || maxPoint.x >= getParent().getWidth()) {
                distance.reverceX();
            }
            if (minPoint.y <= 0 || maxPoint.y >= getParent().getHeight()) {
                distance.reverceY();
            }
        }
    }
}
