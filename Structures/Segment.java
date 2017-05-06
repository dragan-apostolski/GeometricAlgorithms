package GeometricAlgorithms.Structures;

import java.util.ArrayList;
import java.util.List;

public final class Segment {
    Point p1;
    Point p2;

    public Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public List<Point> getPoints(){
        List<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        return points;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    @Override
    public String toString() {
        return "p1: " + p1 + ", p2: " + p2;
    }
}
