package javaSE8.forthe.Really.Impatient;

import java.awt.*;

public class Exercise_9_8 implements Comparable<Point> {
/*8. Implement the compareTo method of the Point class in Section 9.3.3, “Comparing
    Numeric Types,” on page 189, without using Integer.compareTo.*/

    private int x;
    private int y;

    @Override
    public int compareTo(Point other) {
        int diff = (x < other.x) ? -1 : ((x == other.x) ? 0 : 1);
        if (diff != 0) return diff;
        return (y < other.y) ? -1 : ((y == other.y) ? 0 : 1);
    }

}
