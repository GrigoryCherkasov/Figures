package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;

public class FiguresObjects {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static int score = 0;

    public static void main(String[] args) throws InterruptedException {
        final JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLayout(null);

        final JLabel scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setBounds(0,0,100, 10);
        frame.add(scoreLabel);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                }
            }
        });

        frame.getContentPane().addContainerListener(new ContainerAdapter() {
            @Override
            public void componentRemoved(ContainerEvent e) {
                score++;
                scoreLabel.setText("Score: " + score);
                createFigure(frame);
            }
        });


        frame.setVisible(true);

        for (int i = 0; i < 5; i++)
        {
            createFigure(frame);
        }

        while (score < 10) {
            Thread.sleep(10);
            Arrays.stream(frame.getContentPane().getComponents()).
                    filter(component -> component instanceof Figure ).
                    forEach(component -> ((Figure)component).move());
        }

        final JLabel gameOver = new JLabel("Game over");
        gameOver.setForeground(Color.RED);
        gameOver.setFont(new Font(gameOver.getName(), Font.PLAIN, 50));
        gameOver.setBounds(100, 180, 400, 70);
        frame.add(gameOver, 0);
        frame.repaint();

        Thread.sleep(2000);
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    private static void createFigure(JFrame frame){
        int caseFigure = new Random().nextInt(4);
        if(caseFigure <= 1){
            frame.add(Circle.createRandomFigure(frame.getContentPane()));
        } else if(caseFigure <= 2){
            frame.add(Square.createRandomFigure(frame.getContentPane()));
        } else {
            frame.add(Triangle.createRandomFigure(frame.getContentPane()));
        }
    }
}