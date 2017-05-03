package GeometricAlgorithms;

import java.util.*;

public class LineSegments {

    /**
     * This method checks if there is an intersection between any two segments in the given set, returns {@code true}
     * if so, false otherwise.
     * For the method to work correctly, every point in the segments should be defined as either LEFT or RIGHT endpoint
     * of that segment. Sides of a point are represented via the {@link Side} enumeration.
     *
     * The running time of this algorithm implementation is O(n*log(n)), where n is the number of segments in the set.
     *
     * @param segments a set of segments
     * @return true if any two segments in the set intersect, false otherwise
     */
    public static boolean anySegmentIntersects(Set<Segment> segments){
        HashMap<Point, Segment> mappings = new HashMap<>();
        List<Point> points = new ArrayList<>();
        initComponents(segments, points, mappings);

        TreeSet<Point> status = new TreeSet<>(Comparator.comparing(Point::getY));
        for (Point point : points) {
            if(point.side == Side.LEFT){
                status.add(point);
                Segment s = mappings.get(point);
                Segment above = mappings.get(status.higher(point));
                Segment below = mappings.get(status.lower(point));
                if((above != null && segmentsIntersect(s, above)) || (below != null && segmentsIntersect(s, below)))
                    return true;
            }
            else{
                Segment above = mappings.get(status.higher(point));
                Segment below = mappings.get(status.lower(point));
                if(above != null && below != null && segmentsIntersect(above, below))
                    return true;
                status.remove(point);
            }
        }
        return false;
    }

    private static void initComponents(Set<Segment> segments, List<Point> points, HashMap<Point, Segment> mappings) {
        segments.forEach(segment -> {
            List<Point> segmentPoints = segment.getPoints();
            points.addAll(segmentPoints);
            segmentPoints.forEach(point -> mappings.put(point, segment));
        });
        points.sort(Comparator.comparing(Point::getX).thenComparing(Point::getSide).thenComparing(Point::getY));
    }


    /**
     * This method computes whether two line segments s1 and s2 intersect. It calls subroutines
     * direction, which computes the relative orientations using the cross product method, and
     * onSegment, which determines whether a point that is collinear with a segment lies on that
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

    /**
     * Returns the direction of point Pk in terms of the line segment formed by points Pi
     * (LEFT endpoint) and Pj (RIGHT endpoint). If the return value is negative, Pk is LEFT
     * from the line segment (counter-clockwise), if the return value is 0, Pk is collinear
     * with the line segment, and if the return value is positive, Pk is RIGHT from the line
     * segment (clockwise).
     *
     * @param Pi the LEFT endpoint of the line segment
     * @param Pj the RIGHT endpoint of the line segment
     * @param Pk the point who's direction in terms of the line segment Pi - Pj is being questioned
     * @return negative value if CCW, 0 if collinear, positive value if CW
     */
    static double direction(Point Pi, Point Pj, Point Pk){
        Point PkPrime = new Point(Pk.x - Pi.x, Pk.y - Pi.y, Side.LEFT);
        Point PjPrime = new Point(Pj.x - Pi.x, Pj.y - Pi.y, Side.RIGHT);
        return crossProduct(PkPrime, PjPrime);
    }

    private static double crossProduct(Point p1, Point p2){
        return (p1.x * p2.y) - (p2.x * p1.y);
    }
}
