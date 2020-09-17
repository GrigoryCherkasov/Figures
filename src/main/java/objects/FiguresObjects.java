package objects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class FiguresObjects {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    public static void main(String[] args) throws InterruptedException {
        final JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
            }
        });

        frame.add(new Circle(new Point(110, 120), 50,Color.RED, new Point(1, 2)));
        frame.add(new Circle(new Point(90, 60), 30, Color.YELLOW, new Point(2, 2)));
        frame.add(new Square(new Point(30, 50), 40, Color.GREEN, new Point(2, 3)));
        frame.add(new Square(new Point(200, 150), 50, Color.GRAY, new Point(1, 1)));
        frame.add(new Triangle(new Point(40, 30), new Point(55, 80), new Point(90, 70),
                Color.BLUE, new Point(3, 2)));
        frame.add(new Triangle(new Point(200, 250), new Point(240, 180), new Point(270, 220),
                Color.MAGENTA, new Point(2, 1)));

        while (true) {
            Thread.sleep(10);
            for (Component figure : frame.getContentPane().getComponents()) {
                ((Figure)figure).move(frame);
            }
        }
    }
}