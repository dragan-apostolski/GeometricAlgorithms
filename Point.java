package GeometricAlgorithms;

public final class Point {
    double x;
    double y;
    Side side;

    public Point(double x, double y, Side side) {
        this.x = x;
        this.y = y;
        this.side = side;
    }

    public Point(double x, double y){
        this.x = x;
        this.y = y;
        this.side = null;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getSide(){
        return (side == Side.LEFT) ? 0 : 1;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        Point p2 = (Point) obj;
        return x == p2.x && y == p2.y;
    }
}