package javaSE8.forthe.Really.Impatient;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Exercise_9_2 {
    /*    2. Improve on the preceding exercise by adding any exceptions thrown by
    in.close() or out.close() as suppressed exceptions to the original exception, if
        there was one.*/
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
            Throwable[] secondaryExceptions = ex.getSuppressed();
            try {
                in.close();
                pw.close();
            } catch (NullPointerException exNull) {
                System.out.println(exNull);
                for (Throwable t : secondaryExceptions) {
                    exNull.addSuppressed(t);
                }
            }
        }

    }
}
