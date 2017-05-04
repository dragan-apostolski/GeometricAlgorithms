package GeometricAlgorithms.test;

import GeometricAlgorithms.LineSegments;
import GeometricAlgorithms.Point;
import GeometricAlgorithms.Segment;
import GeometricAlgorithms.Side;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class LineSegmentTester {


    @Test
    public static void anySegmentsIntersectTest(){
        /*

        6 |     f
        5 | a
        4 |          d
        3 | c
        2 |         b
        1 |   e
        0 -------------
          0 1 2 3 4 5 6
         */

        Point a = new Point(1, 5, Side.LEFT);
        Point b = new Point(5, 2, Side.RIGHT);
        Point c = new Point(1, 3, Side.LEFT);
        Point d = new Point(5.5, 4, Side.RIGHT);
        Point e = new Point(1.9, 1, Side.LEFT);
        Point f = new Point(3, 6, Side.RIGHT);
        List<Segment> segments = Arrays.asList(new Segment(a, b), new Segment(c, d), new Segment(e, f));

        Set<Segment> segmentSet = new HashSet<>(segments);

        Assert.assertThat(LineSegments.anySegmentIntersects(segmentSet), is(true));
    }

    @Test
    public static void segmentsIntersectTest(){


         /*

        6 |         f
          |
        5 | e
          |
        4 |
          |
        3 | a
          |              d
        2 |           b
          | c
        1 |
        0 -------------------
          0  1  2  3  4  5  6
         */


        Point a = new Point(.7, 3, Side.LEFT);
        Point b = new Point(4, 2, Side.RIGHT);
        Point c = new Point(0.5, 1.5, Side.LEFT);
        Point d = new Point(5, 2.5, Side.RIGHT);

        Point e = new Point(.7, 5, Side.LEFT);
        Point f = new Point(3.5, 6, Side.RIGHT);

        Segment ab = new Segment(a, b);
        Segment cd = new Segment(c, d);
        Segment ef = new Segment(e, f);

        Segment ad = new Segment(a, d);
        Segment cb = new Segment(c, b);

        Segment cf = new Segment(c, f);
        Segment eb = new Segment(e, b);

        Assert.assertThat(LineSegments.segmentsIntersect(ab, cd), is(true));
        Assert.assertThat(LineSegments.segmentsIntersect(ab, ef), is(false));
        Assert.assertThat(LineSegments.segmentsIntersect(ad, cb), is(false));
        Assert.assertThat(LineSegments.segmentsIntersect(cf, eb), is(true));
    }



    public static void main(String[] args) {
        anySegmentsIntersectTest();
        segmentsIntersectTest();
    }
}