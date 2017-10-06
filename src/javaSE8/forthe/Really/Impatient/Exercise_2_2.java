package javaSE8.forthe.Really.Impatient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Exercise_2_2 {
/*    2.Verify that asking for the first five long words does not call the filter method
    once the fifth long word has been found. Simply log each method call.*/

    public static void main(String[] args) throws IOException {

        String contents = new String(Files.readAllBytes(Paths.get("text_example.txt")), StandardCharsets.UTF_8); // Read file into string
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        Stream<String> s = words.stream().filter(x -> x.length() > 10).peek(e -> System.out.println("Fetching " + e)).limit(5);
        s.forEach(System.out::println);

    }
}
