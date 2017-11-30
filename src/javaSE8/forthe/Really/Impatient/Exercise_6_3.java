package javaSE8.forthe.Really.Impatient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Exercise_6_3 {
/*3. Generate 1,000 threads, each of which increments a counter 100,000 times.
    Compare the performance of using AtomicLong versus LongAdder.*/

    public static void main(String[] args) throws IOException {

        final int NUM_OF_THREADS = 1000;
        final int INCREMENTS_AMOUNT = 100000;

        long startTime = System.currentTimeMillis();
        Map<String, AtomicLong> cal = new ConcurrentHashMap();
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < INCREMENTS_AMOUNT; j++) {
                        cal.putIfAbsent("a", new AtomicLong());
                        cal.get("a").incrementAndGet();
                    }
                }
            }).run();
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("AtomicLong elapsedTime [ms]: " + elapsedTime);

        Map<String, LongAdder> cla = new ConcurrentHashMap();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < INCREMENTS_AMOUNT; j++) {
                        cla.putIfAbsent("a", new LongAdder());
                        cla.get("a").increment();
                    }
                }
            }).run();
        }
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        System.out.println("LongAdder elapsedTime [ms]: " + elapsedTime);

        //Conclusion: LongAdder is faster.

    }
}
