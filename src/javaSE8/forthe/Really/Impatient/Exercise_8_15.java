package javaSE8.forthe.Really.Impatient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Exercise_8_15 {
/*    15. Using Files.lines and Pattern.asPredicate, write a program that acts like the grep
    utility, printing all lines that contain a match for a regular expression.*/

    public static void main(String[] args) throws IOException {

        try (Stream<String> lines = Files.lines(Paths.get("D:\\working\\Java SE 8 for the Really Impatient\\war-and-peace.txt"), StandardCharsets.UTF_8)) {
            Stream<String> result = lines.filter(Pattern.compile("[A-Z]{2}").asPredicate());//lines with capital letters with at least two in length
            result.forEach(System.out::println);
        }

    }

}
