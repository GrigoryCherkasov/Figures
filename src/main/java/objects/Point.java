package objects;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void movePoint(Point distance){
        x += distance.x;
        y += distance.y;
    }

    public Point pointIn(int distance){
        return new Point(x + distance, y + distance);
    }

    public void reverceX(){
        x = -x;
    }

    public void reverceY(){
        y = -y;
    }

}
