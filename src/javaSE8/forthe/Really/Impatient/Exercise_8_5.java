package javaSE8.forthe.Really.Impatient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Exercise_8_5 {
/*  5. At the beginning of Chapter 2, we counted long words in a list as
words.stream().filter(w -> w.length() > 12).count(). Do the same with a lambda
    expression, but without using streams. Which operation is faster for a
    long list?*/


    public static void main(String[] args) throws IOException {

        String contents = new String(Files.readAllBytes(Paths.get("some_text.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        words.forEach(w -> {
            if (w.length() > 12) {
                System.out.println(w);
            }
        });

    }

}
