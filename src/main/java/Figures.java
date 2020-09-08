import javax.swing.*;
import java.awt.*;

public class Figures {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLayout(null);
        frame.setVisible(true);
        int xc = 10;
        int dxc = 1;
        int yc = 20;
        int dyc = 2;
        int sizec = 50;

        int xq = 30;
        int dxq = 2;
        int yq = 50;
        int dyq = 3;
        int sizeq = 40;

        int xt = 40;
        int dxt = 3;
        int yt = 30;
        int dyt = 2;
        int sizet = 60;

        Circle circle = new Circle(xc, yc, sizec, Color.red);
        Square square = new Square(xq, yq, sizeq, Color.green);
        Triangle triangle = new Triangle(xt, yt, sizet, Color.blue);

        frame.add(circle);
        frame.add(square);
        frame.add(triangle);

        while (true){
            Thread.sleep(10);
            xc += dxc;
            yc += dyc;
            circle.setLocation(xc, yc);
            if(xc  <= 0 || xc + sizec >= frame.getContentPane().getWidth()){
                dxc = -dxc;
            }
            if(yc <= 0 || yc + sizec >= frame.getContentPane().getHeight()){
                dyc = -dyc;
            }

            xq += dxq;
            yq += dyq;
            square.setLocation(xq, yq);
            if(xq  <= 0 || xq + sizeq >= frame.getContentPane().getWidth()){
                dxq = -dxq;
            }
            if(yq <= 0 || yq + sizeq >= frame.getContentPane().getHeight()){
                dyq = -dyq;
            }

            xt += dxt;
            yt += dyt;
            triangle.setLocation(xt, yt);
            if(xt  <= 0 || xt + sizet >= frame.getContentPane().getWidth()){
                dxt = -dxt;
            }
            if(yt <= 0 || yt + sizet >= frame.getContentPane().getHeight()){
                dyt = -dyt;
            }
        }
    }
}