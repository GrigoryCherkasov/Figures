package game;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(Point distance){
        x += distance.x;
        y += distance.y;
    }

    public void reverceX(){
        x = -x;
    }

    public void reverceY(){
        y = -y;
    }

    public Point getDistancePoint(int distance){
        return new Point(x + distance, y + distance);
    }

}
