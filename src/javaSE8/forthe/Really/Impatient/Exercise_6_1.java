package javaSE8.forthe.Really.Impatient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class Exercise_6_1 {
/*
1. Write a program that keeps track of the longest string that is observed by a
    number of threads. Use an AtomicReference and an appropriate accumulator.
*/

    public static void main(String[] args) throws IOException, InterruptedException {

        AtomicReference<String> longest = new AtomicReference<>("");

        String contents = new String(Files.readAllBytes(Paths.get("war-and-peace.txt")), StandardCharsets.UTF_8); // Read file into string
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        //System.out.println(words.size()); //576144
        ExecutorService pool = Executors.newCachedThreadPool();
        int cores = Runtime.getRuntime().availableProcessors();
        List<List<String>> subLists = new ArrayList(cores);
        subLists.add(words.subList(0, 144036));
        subLists.add(words.subList(144036, 144036 * 2));
        subLists.add(words.subList(144036 * 2, 144036 * 3));
        subLists.add(words.subList(144036 * 3, 576144));

        for (List<String> lst : subLists) {
            pool.submit(
                    new Runnable() {
                        @Override
                        public void run() {
                            for (String s : lst) {
                                String oldVal = longest.get();
                                if (s.length() > oldVal.length()) {
                                    longest.compareAndSet(oldVal, s);
                                }
                            }
                        }
                    }
            );
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.HOURS);

        System.out.println("Longest: " + longest.get());

    }
}
