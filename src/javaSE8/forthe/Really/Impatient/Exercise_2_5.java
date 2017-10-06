package javaSE8.forthe.Really.Impatient;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Exercise_2_5 {
/*5. Using Stream.iterate, make an infinite stream of random numbers—not by
    calling Math.random but by directly implementing a linear congruential generator.
    In such a generator, you start with x0 = seed and then produce xn + 1 =
            (a xn + c) % m, for appropriate values of a, c, and m. You should implement a
    method with parameters a, c, m, and seed that yields a Stream<Long>. Try out a =
            25214903917, c = 11, and m = 248.*/

    public static void main(String[] args) {

        BigInteger a = BigInteger.valueOf(25214903917L);
        BigInteger c = BigInteger.valueOf(11);
        BigInteger m = BigInteger.valueOf(248);

        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n ->n.multiply(a).add(c).mod(m)).limit(10);
        integers.forEach(System.out::println);

    }
}
