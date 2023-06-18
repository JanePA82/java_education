package ru.stqa.edu.sandbox;


import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
    @Test
    public void testDist1(){
    Point p1 = new Point(0,0);
    Point p2 = new Point(3,4);
    double dist = p1.distance(p2);

    assert dist == 5;

    }

    @Test
    public void testDist2(){
        Point p1 = new Point(0,0);
        Point p2 = new Point(3,4);
        double dist = p1.distance(p2);

        assert Math.pow(dist, 2) ==Math.pow(p1.x-p2.x, 2) + Math.pow(p1.y-p2.y, 2);

    }
    @Test
    public void testDist3(){
        Point p1 = new Point(0,0);
        Point p2 = new Point(3,4);
        double dist = p1.distance(p2);
        Assert.assertEquals(Math.pow(dist, 2),Math.pow(p1.x-p2.x, 2) + Math.pow(p1.y-p2.y, 2) );
/*
        assert Math.pow(dist, 2) ==Math.pow(p1.x-p2.x, 2) + Math.pow(p1.y-p2.y, 2);
*/

    }
}
