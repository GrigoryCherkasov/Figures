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
            int[] pozition = getPozition(xc, yc, dxc, dyc, sizec, frame.getContentPane().getWidth(), frame.getContentPane().getHeight());
            xc = pozition[0];
            yc = pozition[1];
            dxc = pozition[2];
            dyc = pozition[3];
            circle.setLocation(xc, yc);

            pozition = getPozition(xq, yq, dxq, dyq, sizeq, frame.getContentPane().getWidth(), frame.getContentPane().getHeight());
            xq = pozition[0];
            yq = pozition[1];
            dxq = pozition[2];
            dyq = pozition[3];
            square.setLocation(xq, yq);

            pozition = getPozition(xt, yt, dxt, dyt, sizet, frame.getContentPane().getWidth(), frame.getContentPane().getHeight());
            xt = pozition[0];
            yt = pozition[1];
            dxt = pozition[2];
            dyt = pozition[3];
            triangle.setLocation(xt, yt);
        }
    }
    private static int[] getPozition(int x, int y, int dx, int dy, int size, int containerWidth, int containerHight){
        int[] result = new int[4];
        x += dx;
        y += dy;
        if(x  <= 0 || x + size >= containerWidth){
            dx = -dx;
        }
        if(y <= 0 || y + size >= containerHight){
            dy = -dy;
        }
        result[0] = x;
        result[1] = y;
        result[2] = dx;
        result[3] = dy;

        return result;
    }
}