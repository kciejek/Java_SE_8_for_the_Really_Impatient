package javaSE8.forthe.Really.Impatient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Exercise_2_3 {
/*3.Measure the difference when counting long words with a parallelStream instead
    of a stream. Call System.currentTimeMillis before and after the call, and print the
    difference. Switch to a larger document (such as War and Peace) if you have
    a fast computer.*/

    public static void main(String[] args) throws IOException {

        String contents = new String(Files.readAllBytes(Paths.get("war-and-peace.txt")), StandardCharsets.UTF_8); // Read file into string
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        long start = System.currentTimeMillis();
        long parallelCount = words.parallelStream().filter(x -> x.length() > 1).count();
        long end = System.currentTimeMillis();
        System.out.println("Parallel count time: " +  TimeUnit.MILLISECONDS.toMillis(end - start) + ", count: " + parallelCount);

        start = System.currentTimeMillis();
        long count = words.stream().filter(x -> x.length() > 1).count();
        end = System.currentTimeMillis();
        System.out.println("Count time: " +  TimeUnit.MILLISECONDS.toMillis(end - start) + ", count: " + count);

    }


}
