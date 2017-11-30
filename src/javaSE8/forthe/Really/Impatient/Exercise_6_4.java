package javaSE8.forthe.Really.Impatient;

import java.util.concurrent.atomic.LongAccumulator;

public class Exercise_6_4 {
/*4. Use a LongAccumulator to compute the maximum or minimum of the
    accumulated elements.*/

    public static void main(String[] args) {

        long[] numLong = new long[]{-1, -2, 10, 34, 3, 4, 6, 5};

        //max
        LongAccumulator adder = new LongAccumulator(Long::max, 0);
        for (int i = 0; i < numLong.length; i++) {
            adder.accumulate(numLong[i]);
        }
        System.out.println("Max: " + adder.get());

        //min
        adder = new LongAccumulator(Long::min, 0);
        for (int i = 0; i < numLong.length; i++) {
            adder.accumulate(numLong[i]);
        }
        System.out.println("Min: " + adder.get());

    }
}
