package javaSE8.forthe.Really.Impatient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Exercise_2_1 {
/*    1. Write a parallel version of the for loop in Section 2.1, “From Iteration to
    Stream Operations,” on page 22. Obtain the number of processors. Make that
    many separate threads, each working on a segment of the list, and total up
    the results as they come in. (You don’t want the threads to update a single
    counter. Why?) */

    static ReentrantLock counterLock = new ReentrantLock(true);

    static int globalCounter = 0;

    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("text_example.txt")), StandardCharsets.UTF_8); // Read file into string
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        //long count = words.stream().filter(x -> x.length() > 7).count();
        //long count = words.parallelStream().filter(x -> x.length() > 7).count();
        int cores = Runtime.getRuntime().availableProcessors();
        //System.out.println(words.size()); //size 1037
        //System.out.println((double)words.size() / cores); //sublist 259
        List<List<String>> subLists = new ArrayList(cores);
        subLists.add(words.subList(0, 259));
        subLists.add(words.subList(259, 259*2));
        subLists.add(words.subList(259*2, 259*3));
        subLists.add(words.subList(259*3, 1037));

        for (List<String> obj:subLists) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int count = 0;
                    for (String w : obj) {
                        if (w.length() > 5) count++;
                    }
                    System.out.println("Count from " + Thread.currentThread().getName() + ", " + count);
                    counterLock.lock();
                    globalCounter += count;
                    counterLock.unlock();
                }
            }).run();
        }

        System.out.println("Globalcounter: " + globalCounter);

        for (List<String> obj:subLists) {
            obj.stream().filter(w -> w.length() > 5).count();

        }
    }
}
