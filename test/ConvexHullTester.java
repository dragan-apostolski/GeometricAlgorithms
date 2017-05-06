package GeometricAlgorithms.test;


import GeometricAlgorithms.Utils.ConvexHull;
import GeometricAlgorithms.Structures.Point;

import java.util.HashSet;
import java.util.Set;

public class ConvexHullTester {

    public static void main(String[] args) {

        Point p0 = new Point(1, 0.6);
        Point p1 = new Point(5, 1.4);
        Point p2 = new Point(4.5, 2.1);
        Point p3 = new Point(6, 3);
        Point p4 = new Point(3.5, 3.1);
        Point p5 = new Point(3, 4.3);
        Point p6 = new Point(1.5, 5);
        Point p7 = new Point(1.4, 4.7);
        Point p8 = new Point(1.3, 3.7);
        Point p9 = new Point(1.25, 4.7);
        Point p10 = new Point(1.25, 9);
        Point p11 = new Point(.9, 4.6);
        Point p12 = new Point(-.25, 2.8);

        Set<Point> points = new HashSet<>();
        points.add(p0);
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);
        points.add(p5);
        points.add(p6);
        points.add(p7);
        points.add(p8);
        points.add(p9);
        points.add(p10);
        points.add(p11);
        points.add(p12);

        System.out.println(ConvexHull.convexHull(points));

    }
}
