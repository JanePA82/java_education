package ru.stqa.edu.sandbox;


public class Distance {
    public static void main (String [] args) {
        Point p1 = new Point(0 ,0 );
        Point p2 = new Point(5 ,12 );
        System.out.println ();
        System.out.println ("Расстояние между точками А("+p1.x+","+p1.y+") и В("+p2.x+","+p2.y+") равно " +distance(p1, p2));
        System.out.println ();
        System.out.println ("Расстояние между точками А("+p1.x+","+p1.y+") и В("+p2.x+","+p2.y+") равно "+ p1.distance(p2));
    }
 public static double distance(Point p1, Point p2) {
	/*	p1.x = 3;
		p2.x = 4;
		p1.y = 3;
		p2.y = 4;*/
        double qwery_dist = (p1.x-p2.x)*(p1.x-p2.x) +(p1.y-p2.y)*(p1.y-p2.y);
        return Math.sqrt (qwery_dist)	;
}
}
