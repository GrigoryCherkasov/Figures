package procedure;

import javax.swing.*;

public class FiguresProc {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private static Circle circle;
    private static Square square;
    private static Triangle triangle;

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLayout(null);
        frame.setVisible(true);

        int[] circleCoordinate = {110, 120, 60, 1, 2};
        int[] squareCoordinate = {30, 50, 40, 2, 3};
        int[] triangleCoordinate = {40, 30, 55, 80, 90, 70, 3, 2};

        circle = new Circle(circleCoordinate[0], circleCoordinate[1], circleCoordinate[2], 0x00ff0000);
        square = new Square(squareCoordinate[0], squareCoordinate[1], squareCoordinate[2], 0x0000ff00);
        triangle = new Triangle(triangleCoordinate[0], triangleCoordinate[1], triangleCoordinate[2],
                triangleCoordinate[3], triangleCoordinate[4], triangleCoordinate[5], 0x000000ff);

        frame.add(circle);
        frame.add(square);
        frame.add(triangle);

        while (true){
            Thread.sleep(10);
            moveCircle(circleCoordinate, frame);
            moveSquare(squareCoordinate, frame);
            moveTriangle(triangleCoordinate, frame);
        }
    }

    private static void moveCircle(int[] coordinate, JFrame frame){
        coordinate[0] += coordinate[3];
        coordinate[1] += coordinate[4];
        circle.setLocation(coordinate[0], coordinate[1]);
        if(coordinate[0] - coordinate[2]  <= 0 || coordinate[0] + coordinate[2] >= frame.getContentPane().getWidth()){
            coordinate[3] = -coordinate[3];
        }
        if(coordinate[1] - coordinate[2] <= 0 || coordinate[1] + coordinate[2] >= frame.getContentPane().getHeight()){
            coordinate[4] = -coordinate[4];
        }
    }

    private static void moveSquare(int[] coordinate, JFrame frame){
        coordinate[0] += coordinate[3];
        coordinate[1] += coordinate[4];
        square.setLocation(coordinate[0], coordinate[1]);
        if(coordinate[0]  <= 0 || coordinate[0] + coordinate[2] >= frame.getContentPane().getWidth()){
            coordinate[3] = -coordinate[3];
        }
        if(coordinate[1] <= 0 || coordinate[1] + coordinate[2] >= frame.getContentPane().getHeight()){
            coordinate[4] = -coordinate[4];
        }
    }

    private static void moveTriangle(int[] coordinate, JFrame frame){
        coordinate[0] += coordinate[6];
        coordinate[1] += coordinate[7];
        coordinate[2] += coordinate[6];
        coordinate[3] += coordinate[7];
        coordinate[4] += coordinate[6];
        coordinate[5] += coordinate[7];
        triangle.setLocation(coordinate[0], coordinate[1]);

        int xMin = Math.min(Math.min(coordinate[0], coordinate[2]), coordinate[4]);
        int xMax = Math.max(Math.max(coordinate[0], coordinate[2]), coordinate[4]);
        int yMin = Math.min(Math.min(coordinate[1], coordinate[3]), coordinate[5]);
        int yMax = Math.max(Math.max(coordinate[1], coordinate[3]), coordinate[5]);

        if(xMin  <= 0 || xMax >= frame.getContentPane().getWidth()){
            coordinate[6] = -coordinate[6];
        }
        if(yMin <= 0 || yMax >= frame.getContentPane().getHeight()){
            coordinate[7] = -coordinate[7];
        }
    }
}