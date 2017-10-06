package javaSE8.forthe.Really.Impatient;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise_2_4 {
/*4.Suppose you have an array int[] values = { 1, 4, 9, 16 }. What is
Stream.of(values)? How do you get a stream of int instead?*/


    public static void main(String[] args) {
        int[] values = { 1, 4, 9, 16 };
        //1 way
        IntStream intStream = Arrays.stream(values);
        intStream.forEach(System.out::println);

        //2 way
        Stream<int[]> streamOfInt = Stream.of(values);
        streamOfInt.flatMapToInt(x -> IntStream.of(x)).forEach(System.out::println);

    }
}
