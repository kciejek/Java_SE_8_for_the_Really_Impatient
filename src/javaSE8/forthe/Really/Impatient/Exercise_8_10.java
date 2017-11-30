package javaSE8.forthe.Really.Impatient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Exercise_8_10 {
/*10. Unzip the src.zip file from the JDK. Using Files.walk, find all Java files that
    contain the keywords transient and volatile.*/

    public static void main(String[] args) throws IOException {

        Files.walk(Paths.get("D:/working/2017-11-09/src")).filter(Files::isRegularFile).filter(FindFiles::withTransientAndVolatile).forEach(System.out::println);

    }

    static class FindFiles {

        static private final String KEY_WORD_ONE = "transient";
        static private final String KEY_WORD_TWO = "volatile";

        static boolean withTransientAndVolatile(Path path) {
            List<String> lines = null;
            try {
                lines = Files.readAllLines(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            boolean[] isKeyword = new boolean[]{false, false};
            for (String s : lines) {
                if (s.contains(KEY_WORD_ONE) && !s.contains("*")) {
                    isKeyword[0] = true;
                }
                if (s.contains(KEY_WORD_TWO) && !s.contains("*")) {
                    isKeyword[1] = true;
                }
            }
            return isKeyword[0] && isKeyword[1];

        }
    }
}
