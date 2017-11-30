package javaSE8.forthe.Really.Impatient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Exercise_9_5 {
/*5. Write a program that reads all characters of a file and writes them out in
    reverse order. Use Files.readAllBytes and Files.write.*/

    public static void main(String[] args) throws IOException {

        byte[] bytes = Files.readAllBytes(Paths.get("war-and-peace.txt"));
        String text = new String(bytes);
        char[] ca = text.toCharArray();
        StringBuilder sb = new StringBuilder("");
        for (int i = (ca.length - 1); i >= 0; i--) {
            sb.append(ca[i]);
        }
        Files.write(Paths.get("war-and-peace_reverse.txt"), sb.toString().getBytes(StandardCharsets.UTF_8));

    }

}
