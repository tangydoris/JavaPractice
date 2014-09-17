import java.util.*;
import java.math.*;

/*
Given the radius, generate a random point inside the circle
 */

public class Circle {
    private static final double radius = 3.75;

    public static Point getRandomPoint(double r) {
        // Generate one random x coordinate
        // Calculate height from (x,0) to circle's edge
        Random rand = new Random();
        double x = -radius + (2*radius) * rand.nextDouble();
        double yMax = Math.sqrt(radius*radius - x*x);
        double y = -yMax + (2*yMax) * rand.nextDouble();
        return new Point(x, y);
    }

    public static void main (String[] args) {
        System.out.println("Radius:\t" + radius);
        System.out.println("Random Point:\t"+getRandomPoint(radius).toString());
    }

    private static class Point {
        private double x, y;

        private Point (double x, double y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "("+x+", "+y+")";
        }
    }

}