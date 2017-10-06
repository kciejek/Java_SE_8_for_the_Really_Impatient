package javaSE8.forthe.Really.Impatient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Exercise_2_11 {
/*11. It should be possible to concurrently collect stream results in a single ArrayList,
    instead of merging multiple array lists, provided it has been constructed with
    the stream’s size, since concurrent set operations at disjoint positions
    are threadsafe. How can you achieve that?*/


    public static void main(String[] args) {

        Stream<String> sOne = Stream.of("Write", "a", "method", "public", "static");
        List<Integer> resList = new ArrayList<>(Arrays.asList(0,0,0,0,0,0));

        sOne.parallel().forEach(s -> {
            switch (s.length()) {
                case 1: {
                    resList.set(0,  resList.get(0) + 1);
                    break;
                }
                case 2: {
                    resList.set(1, resList.get(1) + 1);
                    break;
                }
                case 3: {
                    resList.set(2, resList.get(2) + 1);
                    break;
                }
                case 4: {
                    resList.set(3, resList.get(3) + 1);
                    break;
                }
                case 5: {
                    resList.set(4, resList.get(4) + 1);
                    break;
                }
                case 6: {
                    resList.set(5, resList.get(5) + 1);
                    break;
                }
            }
        });

        for (Integer i : resList) {
            System.out.println(i);
        }

    }
}
