package javaSE8.forthe.Really.Impatient;

import java.util.ArrayList;
import java.util.List;

public class Exercise_1_8 {
   /* 8. What happens when a lambda expression captures values in an enhanced
    for loop such as this one?

    String[] names = { "Peter", "Paul", "Mary" };
    List<Runnable> runners = new ArrayList<>();
    for (String name : names)
            runners.add(() -> System.out.println(name));

    Is it legal? Does each lambda expression capture a different value, or do they
    all get the last value? What happens if you use a traditional loop for (int i = 0;
    i < names.length; i++)?*/

    public static void main(String[] args) {
        String[] names = {"Peter", "Paul", "Mary"};
        List<Runnable> runners = new ArrayList<>();
        for (String name : names)
            runners.add(() -> System.out.println(name));
        System.out.println("\tforeach");
        for (Runnable r : runners) {
            r.run();
        }

        runners.clear();
        for (int i = 0; i < names.length; i++) {
            int finalI = i;
            runners.add(() -> System.out.println(names[finalI]));
        }
        System.out.println("\tfori");
        for (Runnable r : runners) {
            r.run();
        }

        //Is it legal?
        //Yes.

        //Does each lambda expression capture a different value, or do they all get the last value?
        //Lambda expression capture a different value.

        //What happens if you use a traditional loop for (int i = 0;i < names.length; i++)?
        //Same as for "foreach".
    }


}
