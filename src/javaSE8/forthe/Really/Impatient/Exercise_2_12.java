package javaSE8.forthe.Really.Impatient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Exercise_2_12 {
/*12. Count all short words in a parallel Stream<String>, as described in Section 2.13,
    “Parallel Streams,” on page 40, by updating an array of AtomicInteger. Use
    the atomic getAndIncrement method to safely increment each counter.*/

    public static void main(String[] args) throws IOException {


        String contents = new String(Files.readAllBytes(Paths.get("war-and-peace.txt")), StandardCharsets.UTF_8); // Read file into string
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        AtomicInteger counter = new AtomicInteger(0);

        words.parallelStream().forEach(s -> {
            switch (s.length()) {
                case 1: {
                    counter.getAndIncrement();
                    break;
                }
                case 2: {
                    counter.getAndIncrement();
                    break;
                }
                case 3: {
                    counter.getAndIncrement();;
                    break;
                }
                case 4: {
                    counter.getAndIncrement();
                    break;
                }
                case 5: {
                    counter.getAndIncrement();
                    break;
                }
                case 6: {
                    counter.getAndIncrement();
                    break;
                }
            }
        });

        System.out.println("Counter: " + counter.get());

    }
}
