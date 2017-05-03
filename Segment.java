package GeometricAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class Segment {
    Point p1;
    Point p2;

    public Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    List<Point> getPoints(){
        List<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        return points;
    }

    @Override
    public String toString() {
        return "p1: " + p1 + ", p2: " + p2;
    }
}
