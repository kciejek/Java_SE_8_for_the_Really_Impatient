package javaSE8.forthe.Really.Impatient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise_2_13 {
/*13. Repeat the preceding exercise, but filter out the short strings and use the
    collect method with Collectors.groupingBy and Collectors.counting.*/

    public static void main(String[] args) throws IOException {

        String contents = new String(Files.readAllBytes(Paths.get("war-and-peace.txt")), StandardCharsets.UTF_8); // Read file into string
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        Map<Integer, Long> m = words.parallelStream()
                .filter(x -> (x.length() == 1 || x.length() == 2 || x.length() == 3 || x.length() == 4))
                .collect(Collectors.groupingByConcurrent(String::length, Collectors.counting()));
        for (Map.Entry<Integer, Long> s : m.entrySet()) {
            System.out.println("Length: " + s.getKey() + ", amount: " + s.getValue());
        }

    }
}
