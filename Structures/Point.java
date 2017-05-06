package GeometricAlgorithms.Structures;

public final class Point {
    private double x;
    private double y;
    private Side side;

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

    public Side getSide(){
        return side;
    }

    public int getSideAsInt(){
        return (side == Side.LEFT) ? 0 : 1;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Point) {
            Point p2 = (Point) obj;
            return x == p2.x && y == p2.y;
        }
        else throw new ClassCastException("obj is not from class Point");
    }
}