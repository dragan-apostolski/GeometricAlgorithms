package GeometricAlgorithms;

public class LineSegmentTester {

    public static void main(String[] args) {
        Point p1 = new Point(2, 1.5);
        Point p2 = new Point(7.5, 4);
        Point p3 = new Point(2, 1.5);
        Point p4 = new Point(5.5, 1);
        System.out.println(LineSegments.segmentsIntersect(new Segment(p1, p2), new Segment(p3, p4)));
    }
}
