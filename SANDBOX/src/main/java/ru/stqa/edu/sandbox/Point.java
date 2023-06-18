package ru.stqa.edu.sandbox;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

 public  double distance(Point p) {

        double qwery_dist = (p.x-this.x)*(p.x-this.x) +(p.y-this.y)*(p.y-this.y);
        return Math.sqrt (qwery_dist)	;
}}



//    public  double distance (Point p1, Point p2)
