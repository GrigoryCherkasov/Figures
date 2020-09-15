package procedure;

import javax.swing.*;

public class FiguresSome {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;


    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLayout(null);
        frame.setVisible(true);

        int[][] circlesCoordinates = {{110, 120, 60, 1, 2, 0x00ff0000}, {90, 60, 30, 2, 2, 0x00ffff00}};
        int[][] squaresCoordinates = {{30, 50, 40, 2, 3, 0x0000ffff}, {200, 150, 50, 1, 1, 0x0000ff00}};
        int[][] trianglesCoordinates = {{40, 30, 55, 80, 90, 70, 3, 2, 0x000000ff}, {200, 250, 240, 180, 270, 220, 2, 1, 0x00ff00ff}};

        Circle[] circles;
        Square[] squares;
        Triangle[] triangles;

        circles = new Circle[circlesCoordinates.length];
        int i = 0;
        for (int j = 0; j < circlesCoordinates.length; j++){
            Circle circle = new Circle(circlesCoordinates[j][0], circlesCoordinates[j][1], circlesCoordinates[j][2],
                    circlesCoordinates[j][5]);
            frame.add(circle);
            circles[i] = circle;
            i++;
        }

        squares = new Square[squaresCoordinates.length];
        i = 0;
        for (int j = 0; j < squaresCoordinates.length; j++){
            Square square = new Square(squaresCoordinates[j][0], squaresCoordinates[j][1], circlesCoordinates[j][2],
                    squaresCoordinates[j][5]);
            frame.add(square);
            squares[i] = square;
            i++;
        }

        triangles = new Triangle[trianglesCoordinates.length];
        i = 0;
        for (int j = 0; j < trianglesCoordinates.length; j++){
            Triangle triangle = new Triangle(trianglesCoordinates[j][0], trianglesCoordinates[j][1],
                    trianglesCoordinates[j][2], trianglesCoordinates[j][3],
                    trianglesCoordinates[j][4], trianglesCoordinates[j][5], trianglesCoordinates[j][8]);
            frame.add(triangle);
            triangles[i] = triangle;
            i++;
        }


        while (true){
            Thread.sleep(10);
            moveCircle(circlesCoordinates, circles, frame);
            moveSquare(squaresCoordinates, squares, frame);
            moveTriangle(trianglesCoordinates, triangles, frame);
        }
    }

    private static void moveCircle(int[][] coordinates, Circle[] circles, JFrame frame){
        int i = 0;
        for (int[] coordinate : coordinates){
            coordinate[0] += coordinate[3];
            coordinate[1] += coordinate[4];
            circles[i].setLocation(coordinate[0], coordinate[1]);
            i++;
            if(coordinate[0] - coordinate[2]  <= 0 || coordinate[0] + coordinate[2] >= frame.getContentPane().getWidth()){
                coordinate[3] = -coordinate[3];
            }
            if(coordinate[1] - coordinate[2] <= 0 || coordinate[1] + coordinate[2] >= frame.getContentPane().getHeight()){
                coordinate[4] = -coordinate[4];
            }

        }
    }

    private static void moveSquare(int[][] coordinates, Square[] squares, JFrame frame){
        int i = 0;
        for (int[] coordinate : coordinates){
            coordinate[0] += coordinate[3];
            coordinate[1] += coordinate[4];
            squares[i].setLocation(coordinate[0], coordinate[1]);
            i++;
            if(coordinate[0]  <= 0 || coordinate[0] + coordinate[2] >= frame.getContentPane().getWidth()){
                coordinate[3] = -coordinate[3];
            }
            if(coordinate[1] <= 0 || coordinate[1] + coordinate[2] >= frame.getContentPane().getHeight()){
                coordinate[4] = -coordinate[4];
            }

        }
    }

    private static void moveTriangle(int[][] coordinates, Triangle[] triangle, JFrame frame){
        int i = 0;
        for (int[] coordinate : coordinates){
            coordinate[0] += coordinate[6];
            coordinate[1] += coordinate[7];
            coordinate[2] += coordinate[6];
            coordinate[3] += coordinate[7];
            coordinate[4] += coordinate[6];
            coordinate[5] += coordinate[7];
            triangle[i].setLocation(coordinate[0], coordinate[1]);
            i++;

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
}