package javaSE8.forthe.Really.Impatient;

import java.util.Comparator;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Exercise_8_4 {
/*    The Math.nextDown(x) method returns the next smaller floating-point number
    than x, just in case some random process hit x exactly, and we promised a
    number < x. Can this really happen? Consider double r = 1 - generator.
    nextDouble(), where generator is an instance of java.util.Random. Can it ever yield
1? That is, can generator.nextDouble() ever yield 0?*/


    public static void main(String[] args) {


        //System.out.println("a: " + Math.nextDown(0.4));
        Random r = new Random();
        OptionalDouble op = r.doubles(1000000, 0, 1).skip(0).reduce(Double::min);
        System.out.println("min: " + op.getAsDouble());

    }
}
