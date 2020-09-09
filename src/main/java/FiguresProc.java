import javax.swing.*;
import java.awt.*;

public class FiguresProc {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

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
        int sizeC = 50;

        int xq = 30;
        int dxq = 2;
        int yq = 50;
        int dyq = 3;
        int sizeQ = 40;

        int xt = 40;
        int dxt = 3;
        int yt = 30;
        int dyt = 2;
        int sizeT = 60;

        Circle circle = new Circle(xc, yc, sizeC, Color.red);
        Square square = new Square(xq, yq, sizeQ, Color.green);
        Triangle triangle = new Triangle(xt, yt, sizeT, Color.blue);

        frame.add(circle);
        frame.add(square);
        frame.add(triangle);

        while (true){
            Thread.sleep(10);
            int[] position = getPosition(xc, yc, dxc, dyc, sizeC, frame.getContentPane().getWidth(), frame.getContentPane().getHeight());
            xc = position[0];
            yc = position[1];
            dxc = position[2];
            dyc = position[3];
            circle.setLocation(xc, yc);

            position = getPosition(xq, yq, dxq, dyq, sizeQ, frame.getContentPane().getWidth(), frame.getContentPane().getHeight());
            xq = position[0];
            yq = position[1];
            dxq = position[2];
            dyq = position[3];
            square.setLocation(xq, yq);

            position = getPosition(xt, yt, dxt, dyt, sizeT, frame.getContentPane().getWidth(), frame.getContentPane().getHeight());
            xt = position[0];
            yt = position[1];
            dxt = position[2];
            dyt = position[3];
            triangle.setLocation(xt, yt);
        }
    }
    private static int[] getPosition(int x, int y, int dx, int dy, int size, int containerWidth, int containerHeight){
        int[] result = new int[4];
        x += dx;
        y += dy;
        if(x  <= 0 || x + size >= containerWidth){
            dx = -dx;
        }
        if(y <= 0 || y + size >= containerHeight){
            dy = -dy;
        }
        result[0] = x;
        result[1] = y;
        result[2] = dx;
        result[3] = dy;

        return result;
    }
}