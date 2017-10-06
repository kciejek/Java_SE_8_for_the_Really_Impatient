package javaSE8.forthe.Really.Impatient;

import java.io.File;

public class Exercise_1_3 {
    public static void main(String[] args) {
        /*3. Using the list(FilenameFilter) method of the java.io.File class, write a method
		that returns all files in a given directory with a given extension. Use a lambda
		expression, not a FilenameFilter. Which variables from the enclosing scope does
		it capture?*/

        File folder = new File(System.getProperty("user.dir"));
        File[] files = listFilesFromGivenFolder(folder, "txt");
        for (File f : files) {
            System.out.println(f);
        }
        //It captures extension variable.
    }

    private static File[] listFilesFromGivenFolder(final File folder, final String extension) {

        return folder.listFiles( (dir, name) -> { return name.toLowerCase().endsWith(extension); } );

    }
}
