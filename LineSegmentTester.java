package GeometricAlgorithms;

import java.util.HashSet;
import java.util.Set;

public class LineSegmentTester {

    public static void main(String[] args) {
        Set<Segment> points = new HashSet<>();
        Point p1 = new Point(.5, 3.7, Side.left);
        Point p2 = new Point(4, 1.7, Side.right);
        Point p3 = new Point(.6, 1.3, Side.left);
        Point p4 = new Point(5, 1.3, Side.right);
        Point p5 = new Point(2, .6, Side.left);
        Point p6 = new Point(3, 2, Side.right);

        points.add(new Segment(p1, p2));
        points.add(new Segment(p3, p4));
        points.add(new Segment(p5, p6));

        System.out.println(LineSegments.segmentsIntersect(new Segment(p1, p2), new Segment(p5, p6)));
        System.out.println(LineSegments.anySegmentIntersects(points));
    }
}