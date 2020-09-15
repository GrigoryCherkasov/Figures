package procedure;

import javax.swing.*;

public class Figures {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLayout(null);
        frame.setVisible(true);
        int xc = 110;
        int yc = 120;
        int radiusc = 50;
        int dxc = 1;
        int dyc = 2;

        int xq = 30;
        int yq = 50;
        int sizeq = 40;
        int dxq = 2;
        int dyq = 3;

        int x1 = 40;
        int y1 = 30;
        int x2 = 55;
        int y2 = 80;
        int x3 = 90;
        int y3 = 70;
        int dxt = 3;
        int dyt = 2;

        Circle circle = new Circle(xc, yc, radiusc, 0x00ff0000);
        Square square = new Square(xq, yq, sizeq, 0x0000ff00);
        Triangle triangle = new Triangle(x1, y1, x2, y2, x3, y3, 0x000000ff);

        frame.add(circle);
        frame.add(square);
        frame.add(triangle);

        while (true){
            Thread.sleep(10);

            xc += dxc;
            yc += dyc;
            circle.setLocation(xc, yc);

            if(xc - radiusc  <= 0 || xc + radiusc >= frame.getContentPane().getWidth()){
                dxc = -dxc;
            }
            if(yc - radiusc <= 0 || yc + radiusc >= frame.getContentPane().getHeight()){
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

            x1 += dxt;
            y1 += dyt;
            x2 += dxt;
            y2 += dyt;
            x3 += dxt;
            y3 += dyt;
            triangle.setLocation(x1, y1);

            int xMin = Math.min(Math.min(x1, x2), x3);
            int xMax = Math.max(Math.max(x1, x2), x3);
            int yMin = Math.min(Math.min(y1, y2), y3);
            int yMax = Math.max(Math.max(y1, y2), y3);

            if(xMin  <= 0 || xMax >= frame.getContentPane().getWidth()){
                dxt = -dxt;
            }
            if(yMin <= 0 || yMax >= frame.getContentPane().getHeight()){
                dyt = -dyt;
            }
        }
    }
}