package javaSE8.forthe.Really.Impatient;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Exercise_6_5_and_6_6 {
/*5. Write an application in which multiple threads read all words from a collection
    of files. Use a ConcurrentHashMap<String, Set<File>> to track in which files
    each word occurs. Use the merge method to update the map.*/

/*6. Repeat the preceding exercise, but use computeIfAbsent instead. What is the
    advantage of this approach?*/


    public static void main(String[] args) throws IOException {

        File[] fileArray = new File[]{new File("war-and-peace.txt"), new File("some_text.txt"), new File("text_example.txt")};
        Map<String, Set<File>> m = new ConcurrentHashMap<>();
        final String[] words = {"a", "an", "the", "says", "nice"};//words to search

        //merge
        for (int i = 0; i < fileArray.length; i++) {

            int j = i;
            new Thread(() -> {
                {
                    String contents = null;
                    try {
                        contents = new String(Files.readAllBytes(fileArray[j].toPath()), StandardCharsets.UTF_8);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    for (int n = 0; n < words.length; n++) {
                        if (contents.contains(words[n])) {
                            Set<File> mTmp = new TreeSet();
                            mTmp.add(fileArray[j]);
                            m.merge(words[n], mTmp, (k, v) -> {
                                Set<File> s = new TreeSet(k);
                                s.addAll(v);
                                return s;
                            });
                        }
                    }
                }
            }).run();
        }

        System.out.println("For merge: " + m);


        //computeIfAbsent
        for (int i = 0; i < fileArray.length; i++) {

            int j = i;
            new Thread(() -> {
                {
                    String contents = null;
                    try {
                        contents = new String(Files.readAllBytes(fileArray[j].toPath()), StandardCharsets.UTF_8);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    for (int n = 0; n < words.length; n++) {
                        if (contents.contains(words[n])) {
                            m.computeIfAbsent(words[n], k -> new TreeSet<>()).add(fileArray[j]);
                        }
                    }
                }
            }).run();
        }

        System.out.println("For computeIfAbsent: " + m);
        //Q. What is the advantage of this approach?
        //A. Less code and it's clear,

    }

}
