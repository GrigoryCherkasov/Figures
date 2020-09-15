package objects;

import javax.swing.*;
import java.awt.*;

public abstract class Figure extends AbstractButton{
    protected Point distance;
    protected Color color;
    public abstract void move(JFrame frame);
}
