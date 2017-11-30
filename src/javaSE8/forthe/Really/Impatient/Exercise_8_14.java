package javaSE8.forthe.Really.Impatient;

import java.util.Objects;

public class Exercise_8_14 {
/*14. Demonstrate the use of the Objects.requireNonNull method and show how it
    leads to more useful error messages.*/
    public String str;

    public static void main(String[] args) {

        Exercise_8_14 exer = new Exercise_8_14();
        exer.str = "example";

        Exercise_8_14 newExer = new Exercise_8_14();
        newExer.str = "new example";
        exer.str = Objects.requireNonNull(newExer.str,
                () -> "string for " + exer.str + " must not be null");
    }
}
