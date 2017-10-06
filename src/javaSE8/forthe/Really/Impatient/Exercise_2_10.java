package javaSE8.forthe.Really.Impatient;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Exercise_2_10 {
/*10. Write a call to reduce that can be used to compute the average of a Stream<Double>.
    Why can’t you simply compute the sum and divide by count()?*/

    public static void main(String[] args) {

        DoubleStream ds = DoubleStream.iterate(0, n -> n * 2).limit(20);
        Stream<Double> sd = Stream.of(Double.valueOf(1.11),Double.valueOf(2.22),Double.valueOf(3.33));
        OptionalDouble res = sd.mapToDouble(Double::doubleValue).average();
        System.out.println("Average: " + res.getAsDouble());

        //Q. Why can’t you simply compute the sum and divide by count()?
        //A. Cause sum and count are terminal operations. Stream will be closed after each call to sum/count.
        //double sum = sd.mapToDouble(Double::doubleValue).sum();
        //double count = sd.mapToDouble(Double::doubleValue).count();
    }

}
