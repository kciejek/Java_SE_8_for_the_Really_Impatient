package javaSE8.forthe.Really.Impatient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Exercise_9_6 {
/*6. Write a program that reads all lines of a file and writes them out in reverse
    order. Use Files.readAllLines and Files.write.*/

    public static void main(String[] args) throws IOException {

        List<String> text = Files.readAllLines(Paths.get("war-and-peace.txt"));
        String[] textArray = text.toArray(new String[text.size()]);
        StringBuilder sb = new StringBuilder("");
        for (int i = (textArray.length - 1); i >= 0; i--) {
            sb.append(textArray[i]);
        }
        Files.write(Paths.get("war-and-peace_reverse_lines.txt"), sb.toString().getBytes(StandardCharsets.UTF_8));

    }

}
