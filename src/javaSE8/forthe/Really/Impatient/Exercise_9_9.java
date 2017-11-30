package javaSE8.forthe.Really.Impatient;

import java.util.Objects;

public class Exercise_9_9 {
/*9. Given a class
    public class LabeledPoint {
        private String label;
        private int x;
        private int y;
        ...
    }
    implement the equals and hashCode methods.*/

    public class LabeledPoint {
        private String label;
        private int x;
        private int y;

        @Override
        public boolean equals(Object obj) {
            LabeledPoint lp = (LabeledPoint) obj;
            return Objects.equals(x, lp.x) && Objects.equals(y, lp.y);
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Exercise_9_9 exer = new Exercise_9_9();
        LabeledPoint point1 = exer.new LabeledPoint();
        point1.setX(2);
        point1.setY(2);
        LabeledPoint point2 = exer.new LabeledPoint();
        point2.setX(1);
        point2.setY(2);
        System.out.println("equals: " + point1.equals(point2));
    }


}
