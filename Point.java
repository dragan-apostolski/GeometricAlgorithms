package GeometricAlgorithms;


enum Side{
    left,
    right
}

public class Point {
    double x;
    double y;
    Side side;

    public Point(double x, double y, Side side) {
        this.x = x;
        this.y = y;
        this.side = side;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getSide(){
        return (side == Side.left) ? 0 : 1;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}