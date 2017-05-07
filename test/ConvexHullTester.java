package GeometricAlgorithms.test;


import GeometricAlgorithms.Structures.Point;
import GeometricAlgorithms.Utils.ConvexHull;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class ConvexHullTester {

    @Test(expected = IllegalArgumentException.class)
    public void convexHullExceptionTester(){
        Set<Point> points = new HashSet<>();
        Point p0 = new Point(1, 0.6);
        Point p1 = new Point(5, 1.4);
        points.add(p0);
        points.add(p1);
        ConvexHull.convexHull(points).forEach(System.out::println);
    }

    @Test(expected = IllegalArgumentException.class)
    public void collinearityTest(){
        Point p0 = new Point(2, 2);
        Point p1 = new Point(3, 2);
        Point p2 = new Point(4, 2);
        Set<Point> points = new HashSet<>(Arrays.asList(p0, p1, p2));
        ConvexHull.convexHull(points);
    }


    @Test
    public void nonCollinearityTest(){

        Point p0 = new Point(2, 2);
        Point p1 = new Point(3, 2);
        Point p2 = new Point(4, 2);
        Point p3 = new Point(5, 2);
        Point p4 = new Point(3.5, 3);

        Set<Point> points = new HashSet<>(Arrays.asList(p0, p1, p2, p3, p4));
        ConvexHull.convexHull(points);
    }

    @Test
    public void convexHullTester1() {
        Point a = new Point(1, 0.45);
        Point b = new Point(2.6, 0.7);
        Point c = new Point(3.3, 1.8);
        Point d = new Point(2, 1.75);
        Point e = new Point(4.5, 3.1);
        Point f = new Point(1.6, 4.3);
        Point g = new Point(0.95, 1.95);
        Point h = new Point(1.55, 2.6);

        Set<Point> points = new HashSet<>(Arrays.asList(a, b, c, d, e, f, g, h));
        List<Point> expected = Arrays.asList(a, b, e, f, g);

        Assert.assertEquals(expected, ConvexHull.convexHull(points));
    }

    @Test
    public void convexHullTester2() {
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

        Set<Point> points = new HashSet<>(Arrays.asList(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12));
        List<Point> expected = Arrays.asList(p0, p1, p3, p10, p12);
        Assert.assertEquals(expected, ConvexHull.convexHull(points));
    }


    @Test
    public void convexHullTester3(){

        Point p0 = new Point(1, 0.5);
        Point p1 = new Point(3, 0.8);
        Point p2 = new Point(2, 1.6);
        Point p3 = new Point(4.2, 2.5);
        Point p4 = new Point(2.5, 4);
        Point p5 = new Point(2.1, 2.5);
        Point p6 = new Point(0.7, 2.9);
        Point p7 = new Point(.2, 1.5);
        Point p8 = new Point(1.5, 2);

        Set<Point> points = new HashSet<>(Arrays.asList(p0, p1, p2, p3, p4, p5, p6, p7, p8));
        List<Point> expected = Arrays.asList(p0, p1, p3, p4, p6, p7);
        Assert.assertEquals(expected, ConvexHull.convexHull(points));


        Point p9 = new Point(2.5, 7);

        points = new HashSet<>(Arrays.asList(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9));
        expected = Arrays.asList(p0, p1, p3, p9, p6, p7);

        Assert.assertEquals(expected, ConvexHull.convexHull(points));
    }
}
