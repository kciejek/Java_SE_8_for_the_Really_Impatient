package javaSE8.forthe.Really.Impatient;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Exercise_9_1 {
/*1. Implement a code segment that constructs a Scanner and a PrintWriter at the
    end of Section 9.1.1, “The try-with-resources Statement,” on page 180, without
    the try-with-resources statement. Be sure to close both objects, provided they
    have been properly constructed. You need to consider the following
    conditions:
            • The Scanner constructor throws an exception.
            • The PrintWriter constructor throws an exception.
            • hasNext, next, or println throws an exception.
            • in.close() throws an exception.
            • out.close() throws an exception.*/

    public static void main(String[] args) {

        Scanner in = null;
        PrintWriter pw = null;
        try {
            in = new Scanner(Paths.get("/usr/share/dict/words"));
            pw = new PrintWriter("/tmp/out.txt");
            while (in.hasNext()) {
                pw.println(in.next());
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                in.close();
                pw.close();
            } catch (NullPointerException ex) {
                System.out.println(ex);
            }
        }

    }
}
