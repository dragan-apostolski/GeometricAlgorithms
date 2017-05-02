package GeometricAlgorithms;

public class LineSegments {


    /**
     * This method computes whether two line segments s1 and s2 intersect. It calls subroutines
     * direction, which computes the relative orientations using the cross product method, and
     * onSegment, which determines whether a point that is colinear with a segment lies on that
     * segment.
     *
     * @param s1 the first line segment
     * @param s2 the second line segment
     * @return true if line segments s1 and s2 intersect, false otherwise
     */
    public static boolean segmentsIntersect(Segment s1, Segment s2){
        Point p1 = s1.p1;
        Point p2 = s1.p2;
        Point p3 = s2.p1;
        Point p4 = s2.p2;
        double d1 = direction(p3, p4, p1);
        double d2 = direction(p3, p4, p2);
        double d3 = direction(p1, p2, p3);
        double d4 = direction(p1, p2, p4);

        if( ((d1>0 && d2<0) || (d1<0 && d2>0)) && ((d3>0 && d4<0) || (d3<0 && d4>0)) )
            return true;
        else if (d1 == 0 && onSegment(p3, p4, p1))
            return true;
        else if (d2 == 0 && onSegment(p3, p4, p2))
            return true;
        else if (d3 == 0 && onSegment(p1, p2, p3))
            return true;
        else if (d4 == 0 && onSegment(p1, p2, p4))
            return true;

        return false;
    }

    private static boolean onSegment(Point Pi, Point Pj, Point Pk){
        return (Pk.x >= Math.min(Pi.x, Pj.x) && Pk.x <= Math.max(Pi.x, Pj.x))
                && (Pk.y >= Math.min(Pi.y, Pj.y) && Pk.y <= Math.max(Pi.y, Pj.y));
    }

    private static double direction(Point Pi, Point Pj, Point Pk){
        Point PkPrime = new Point(Pk.x - Pi.x, Pk.y - Pi.y);
        Point PjPrime = new Point(Pj.x - Pi.x, Pj.y - Pi.y);
        return crossProduct(PkPrime, PjPrime);
    }

    private static double crossProduct(Point p1, Point p2){
        return (p1.x * p2.y) - (p2.x * p1.y);
    }
}