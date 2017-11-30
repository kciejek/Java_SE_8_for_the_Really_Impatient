package javaSE8.forthe.Really.Impatient;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Comparator;

public class Exercise_8_6 {
 /*6. Using only methods of the Comparator class, define a comparator for Point2D
    which is a total ordering (that is, the comparator only returns zero for equal
            objects). Hint: First compare the x-coordinates, then the y-coordinates. Do
    the same for Rectangle2D.*/


    public static void main(String[] args) {

        Point2D a = new Point2D() {
            @Override
            public double getX() {
                return 2;
            }

            @Override
            public double getY() {
                return 3;
            }

            @Override
            public void setLocation(double x, double y) {
                return;
            }
        };

        Point2D b = new Point2D() {
            @Override
            public double getX() {
                return 2;
            }

            @Override
            public double getY() {
                return 3;
            }

            @Override
            public void setLocation(double x, double y) {
                return;
            }
        };

        Comparator<Point2D> c = (Point2D o1, Point2D o2) -> {
            if (o1.getX() == o2.getX() && o1.getY() == o2.getY()) {
                return 0;
            }
            return -1;
        };

        System.out.println("Point2D compare result: " + c.compare(a, b));


        Rectangle2D recA = new Rectangle2D(){

            @Override
            public double getX() {
                return 0;
            }

            @Override
            public double getY() {
                return 0;
            }

            @Override
            public double getWidth() {
                return 2;
            }

            @Override
            public double getHeight() {
                return 3;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void setRect(double x, double y, double w, double h) {

            }

            @Override
            public int outcode(double x, double y) {
                return 0;
            }

            @Override
            public Rectangle2D createIntersection(Rectangle2D r) {
                return null;
            }

            @Override
            public Rectangle2D createUnion(Rectangle2D r) {
                return null;
            }
        };

        Rectangle2D recB = new Rectangle2D(){

            @Override
            public double getX() {
                return 0;
            }

            @Override
            public double getY() {
                return 0;
            }

            @Override
            public double getWidth() {
                return 2;
            }

            @Override
            public double getHeight() {
                return 3;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void setRect(double x, double y, double w, double h) {

            }

            @Override
            public int outcode(double x, double y) {
                return 0;
            }

            @Override
            public Rectangle2D createIntersection(Rectangle2D r) {
                return null;
            }

            @Override
            public Rectangle2D createUnion(Rectangle2D r) {
                return null;
            }
        };

        Comparator<Rectangle2D> recComp = (Rectangle2D r1, Rectangle2D r2) -> {
            if (r1.getWidth() == r2.getWidth() && r1.getHeight() == r2.getHeight()) {
                return 0;
            }
            return -1;
        };

        System.out.println("Rectangle2D compare result: " + recComp.compare(recA, recB));

    }





}
