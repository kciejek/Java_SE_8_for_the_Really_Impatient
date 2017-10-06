package javaSE8.forthe.Really.Impatient;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Exercise_2_7 {
/*7. Your manager asks you to write a method public static <T> boolean
    isFinite(Stream<T> stream). Why isn’t that such a good idea? Go ahead and
    write it anyway.*/

    public static void main(String[] args) {
        Stream<BigInteger> s = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        boolean b = Exercise_2_7.isFinite(s);
        System.out.println("Infinite?: " + b);
    }

    public static <T> boolean isFinite(Stream<T> stream){
        Long l = stream.count();
        return l < Long.MAX_VALUE;
    }
}
