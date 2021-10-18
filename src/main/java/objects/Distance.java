package objects;

public class Distance extends Point {

    public Distance(int x, int y) {
        super(x, y);
    }

    public void reverceX(){
        x = -x;
    }

    public void reverceY(){
        y = -y;
    }

}
