package javaSE8.forthe.Really.Impatient;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise_1_4 {
    public static void main(String[] args) {
        /*4. Given an array of File objects, sort it so that the directories come before the
		files, and within each group, elements are sorted by path name. Use a lambda
		expression, not a Comparator.*/

        File folder = new File(System.getProperty("user.dir"));
        File[] dirsAndFiles = folder.listFiles();
        Stream<File> s = Stream.of(dirsAndFiles);
        Map<Boolean, List<File>> r = s.sorted().collect(Collectors.partitioningBy(f -> f.isFile()));
        r.entrySet().forEach(entry -> {
            if(entry.getKey()){
                System.out.println("Files");
            }else{
                System.out.println("Directories");
            }
            entry.getValue().forEach(System.out::println);
        });
       /* for (Map.Entry<Boolean,  List<File>> entry : r.entrySet()) {
            Boolean key = entry.getKey();
            List<File> value = entry.getValue();
            System.out.println(key);
            for (File f : value) {
                System.out.println(f);
            }

        }*/



    }
}
