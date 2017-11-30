package javaSE8.forthe.Really.Impatient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Exercise_6_8 {

/*
8. How large does an array have to be for Arrays.parallelSort to be faster than
    Arrays.sort on your computer?
*/

    public static void main(String[] args) throws IOException {

        String contents = new String(Files.readAllBytes(Paths.get("war-and-peace.txt")), StandardCharsets.UTF_8); // Read file into string
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        String[] wordsArray = words.toArray(new String[]{});
        System.out.println("Array size: " + wordsArray.length);

        long startTime = System.currentTimeMillis();
        Arrays.sort(wordsArray);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Arrays.sort elapsedTime [ms]: " + elapsedTime);

        startTime = System.currentTimeMillis();
        Arrays.parallelSort(wordsArray);
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        System.out.println("Arrays.parallelSort elapsedTime [ms]: " + elapsedTime);

    }
}
