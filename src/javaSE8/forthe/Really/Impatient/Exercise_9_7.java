package javaSE8.forthe.Really.Impatient;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Exercise_9_7 {
/*7. Write a program that reads the contents of a web page and saves it to a file.
    Use URL.openStream and Files.copy.*/

    public static void main(String[] args) throws IOException {

        URL url = new URL("https://www.google.pl");
        Files.copy(url.openStream(), Paths.get("google_pl_offline.html"));

    }

}
