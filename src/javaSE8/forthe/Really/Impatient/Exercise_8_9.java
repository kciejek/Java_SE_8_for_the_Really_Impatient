package javaSE8.forthe.Really.Impatient;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Exercise_8_9 {
/*9. Write methods that turn a Scanner into a stream of words, lines, integers, or
    double values. Hint: Look at the source code for BufferedReader.lines.*/

    public static void main(String[] args) {

        List<String> lst = new ArrayList<>();
        lst.add("one");
        lst.add("two");
        lst.add("three");
        Exercise_8_9 exer = new Exercise_8_9();
        Stream<String> s = exer.scannerLines();
        s.forEach(System.out::println);
    }

    public Stream<String> scannerLines(){

        Iterator<String> iter = new Iterator<String>() {
            String nextLine = null;
            Scanner scanner = new Scanner(System.in);

            @Override
            public boolean hasNext() {
                if (nextLine != null) {
                    return true;
                } else {
                    try {
                        nextLine = scanner.nextLine();
                        return (nextLine != null);
                    } catch (NoSuchElementException e) {
                        throw new NoSuchElementException();
                    }catch (IllegalStateException e) {
                        throw new IllegalStateException(e);
                    }
                }
            }

            @Override
            public String next() {
                if (nextLine != null || hasNext()) {
                    String line = nextLine;
                    nextLine = null;
                    return line;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }

}
