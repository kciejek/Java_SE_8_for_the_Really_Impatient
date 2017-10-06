package javaSE8.forthe.Really.Impatient;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class Exercise_1_2 {
    public static void main(String[] args) {
        /*
		 * 2. Using the listFiles(FileFilter) and isDirectory methods of the
		 * java.io.File class, write a method that returns all subdirectories of a given
		 * directory. Use a lambda expression instead of a FileFilter object. Repeat
		 * with a method expression.
		 */

        File folder = new File(System.getProperty("user.dir"));
        List<String> subDirectories = new ArrayList<>();
        listSubdirectoriesForFolder(folder, subDirectories);
        System.out.println("With FileFilter");
        for (String s : subDirectories) {
            System.out.println(s);
        }

        subDirectories.clear();
        listSubdirectoriesForFolderLambdaExpr(folder, subDirectories);
        System.out.println("With lambda expression");
        for (String s : subDirectories) {
            System.out.println(s);
        }

        subDirectories.clear();
        listSubdirectoriesForFolderLambdaMethodExpr(folder, subDirectories);
        System.out.println("With lambda method expression");
        for (String s : subDirectories) {
            System.out.println(s);
        }
    }

    class MyFilter implements FileFilter {

        @Override
        public boolean accept(File pathname) {
            return pathname.isDirectory();
        }

    }

    private static void listSubdirectoriesForFolder(final File folder, List<String> subDirectories) {
        for (final File f : folder.listFiles(new Exercise_1_2().new MyFilter())) {
            subDirectories.add(f.getAbsolutePath());
            listSubdirectoriesForFolder(f, subDirectories);
        }
    }

    private static void listSubdirectoriesForFolderLambdaExpr(final File folder, List<String> subDirectories) {
        for (final File f : folder.listFiles(x -> x.isDirectory())) {
            subDirectories.add(f.getAbsolutePath());
            listSubdirectoriesForFolderLambdaExpr(f, subDirectories);
        }
    }

    private static void listSubdirectoriesForFolderLambdaMethodExpr(final File folder, List<String> subDirectories) {
        for (final File f : folder.listFiles(File::isDirectory)) {
            subDirectories.add(f.getAbsolutePath());
            listSubdirectoriesForFolderLambdaExpr(f, subDirectories);
        }
    }

}
