package javaSE8.forthe.Really.Impatient;

import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.Set;

public class Exercise_3_7 {
/*7. Write a method that generates a Comparator<String> that can be normal or reversed,
     case-sensitive or case-insensitive, space-sensitive or space-insensitive,
     or any combination thereof. Your method should return a lambda expression.*/

    public static void main(String[] args) {

        Comparator<String> c = Exercise_3_7.comparatorGenerator();
        System.out.println("Normal: " + c.compare("hello", "Hello"));
        c = Exercise_3_7.comparatorGenerator(EnumSet.of(Mode.COMPARE_REVERSED));
        System.out.println("Reversed: " + c.compare("hello", "Hello"));
        c = Exercise_3_7.comparatorGenerator(EnumSet.of(Mode.COMPARE_CASE_INSENSITIVE));
        System.out.println("Case insensitive: " + c.compare("hello", "Hello"));
        c = Exercise_3_7.comparatorGenerator(EnumSet.of(Mode.COMPARE_SPACE_INSENSITIVE));
        System.out.println("Reversed: " + c.compare("he llo", "hello"));
        c = Exercise_3_7.comparatorGenerator(EnumSet.of(Mode.COMPARE_SPACE_INSENSITIVE, Mode.COMPARE_CASE_INSENSITIVE));
        System.out.println("Space and case insensitive: " + c.compare("he llo", "Hello"));
    }

    public static Comparator<String> comparatorGenerator() {
        return Exercise_3_7.comparatorGenerator(Collections.emptySet());
    }

    public static Comparator<String> comparatorGenerator(Set<Mode> flags) {

        return (s, t) -> {
            if (flags.contains(Mode.COMPARE_REVERSED)) {
                String tmp = s;
                s = t;
                t = tmp;
            }
            if (flags.contains(Mode.COMPARE_CASE_INSENSITIVE)) {
                s = s.toLowerCase();
                t = t.toLowerCase();
            }
            if (flags.contains(Mode.COMPARE_SPACE_INSENSITIVE)) {
                s = s.replaceAll("\\s", "");
                t = t.replaceAll("\\s", "");
            }

            return s.compareTo(t);
        };

    }

    public enum Mode {
        COMPARE_REVERSED,
        COMPARE_CASE_INSENSITIVE,
        COMPARE_SPACE_INSENSITIVE
    }


}
