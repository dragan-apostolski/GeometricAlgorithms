package GeometricAlgorithms.Utils;

import GeometricAlgorithms.Structures.Point;

import java.util.*;

public class ConvexHull {

    private enum AngleDirection{
        CLOCKWISE,
        COUNTERCLOCKWISE,
        COLLINEAR
    }


    /**
     * This method finds the convex hull of the given set of points using the {@code grahamScan} method in
     * O(n*log(n)) time, and returns a list of points contained in the convex hull in counter-clockwise
     * order.
     *
     * A {@link IllegalArgumentException} is thrown if less than three points are provided in the set.
     *
     * @param points a set of points in the 2D coordinate system
     * @return a CCW ordered list of points containing the convex hull
     * @throws IllegalArgumentException if less than three points are provided
     */
    public static List<Point> convexHull(Set<Point> points){
        if(points.size() < 3) throw new IllegalArgumentException("At least three points must provided");
        return new ArrayList<>(grahamScan(points));
    }


    /**
     * An implementation of the Graham's scan algorithm for finding the convex hull of a set of points.
     * The algorithm progresses rotationally, considering the points in CCW order. Upon termination, the
     * stack returned by this method contains from bottom to top, in CCW order, the points of the convex
     * hull.
     * The running time is O(n*log(n)), where n is the number of points in the given set.
     *
     * @param points a set of points in the 2D coordinate system
     * @return a stack which contains the points of the convex hull
     * @throws IllegalArgumentException if the set contains less than three unique points
     */
    private static Stack<Point> grahamScan(Set<Point> points){
        List<Point> sortedPoints = new ArrayList<>(sortedPointsSet(points));

        if(sortedPoints.size() < 3)
            throw new IllegalArgumentException("At least three unique points must be provided");
        if(pointsAreCollinear(sortedPoints))
            throw new IllegalArgumentException("Points must not be collinear");

        Stack<Point> stack = new Stack<>();
        stack.push(sortedPoints.get(0));
        stack.push(sortedPoints.get(1));
        stack.push(sortedPoints.get(2));

        for (int i = 3; i < sortedPoints.size(); i++) {
            Point top = stack.pop();
            Point nextToTop = stack.peek();
            Point pi = sortedPoints.get(i);

            AngleDirection direction = getAngleDirection(nextToTop, top, pi);

            switch (direction){
                case COUNTERCLOCKWISE: {
                    stack.push(top);
                    stack.push(pi);
                    break;
                }
                case CLOCKWISE: {
                    i--;
                    break;
                }
                case COLLINEAR:{
                    stack.push(pi);
                    break;
                }
            }
        }
        return stack;
    }

    private static boolean pointsAreCollinear(List<Point> points){

        Point p0 = points.get(0);
        Point p1 = points.get(1);

        for (int i = 2; i < points.size(); i++) {
            Point pi = points.get(i);
            if(getAngleDirection(p0, p1, pi) != AngleDirection.COLLINEAR)
                return false;
        }

        return true;
    }


    private static TreeSet<Point> sortedPointsSet(Set<Point> points){
        final Point lowest = points.stream()
                .sorted(Comparator.comparing(Point::getY).thenComparing(Point::getX))
                .findFirst()
                .orElseThrow(RuntimeException::new);


        TreeSet<Point> sortedPointSet = new TreeSet<>((p1, p2) -> {
            if(p1 == p2 || p1.equals(p2))
                return 0;

            Point p1Prime = new Point(p1.getX() - lowest.getX(), p1.getY() - lowest.getY());
            Point p2Prime = new Point(p2.getX() - lowest.getX(), p2.getY() - lowest.getY());

            double thetaP1 = Math.atan2(p1Prime.getY(), p1Prime.getX());
            double thetaP2 = Math.atan2(p2Prime.getY(), p2Prime.getX());

            if (thetaP1 < thetaP2)
                return -1;
            else if (thetaP1 > thetaP2)
                return 1;
            else{
                // collinear with the 'lowest' point, let the point closest to it come first
                double distanceP1 = distance(p1, lowest);
                double distanceP2 = distance(p2, lowest);

                if(distanceP1 < distanceP2) return -1;
                else return 1;
            }
        });
        sortedPointSet.addAll(points);
        return sortedPointSet;
    }

    private static AngleDirection getAngleDirection(Point p1, Point p2, Point p3) {
        double direction = LineSegments.direction(p1, p2, p3);
        if (direction > 0)
            return AngleDirection.CLOCKWISE;
        else if (direction < 0)
            return AngleDirection.COUNTERCLOCKWISE;
        else return AngleDirection.COLLINEAR;
    }

    private static double distance(Point p1, Point p2){
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

}