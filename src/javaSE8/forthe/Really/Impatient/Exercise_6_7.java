package javaSE8.forthe.Really.Impatient;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Exercise_6_7 {

/*7. In a ConcurrentHashMap<String, Long>, find the key with
    maximum value (breaking ties arbitrarily). Hint: reduceEntries.*/

    public static void main(String[] args) {

        Map<String, Long> m = new ConcurrentHashMap();
        m.put("three", 3L);
        m.put("two", 10L);
        m.put("one", 5L);

        long max = m.values().stream().reduce(Long::max).get();
        System.out.println("Max: " + max);

    }
}
