package javaSE8.forthe.Really.Impatient;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class Exercise_3_9 {
/*9. Write a method lexicographicComparator(String... fieldNames) that yields a comparator
    that compares the given fields in the given order. For example, a
    lexicographicComparator("lastname", "firstname") takes two objects and, using
    reflection, gets the values of the lastname field. If they are different, return the
    difference, otherwise move on to the firstname field. If all fields match, return 0.*/

    class Person {
        private String lastname;
        private String firstname;

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }
    }

    private Person personA;
    private Person personB;

    public Exercise_3_9() {

        personA = new Person();
        personA.setFirstname("John");
        personA.setLastname("Kowalski");

        personB = new Person();
        personB.setFirstname("John");
        personB.setLastname("Nowak");
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {

        Exercise_3_9 exer = new Exercise_3_9();
        System.out.println("Found diff: " + exer.lexicographicComparator("firstname", "lastname"));

    }


    private int lexicographicComparator(String... fieldNames) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        Comparator<String> comp = Exercise_3_9.comparatorGenerator();

        Field f = null;

        Object valA = null, valB = null;

        for (String field : fieldNames) {
            f = this.personA.getClass().getDeclaredField(field);
            f.setAccessible(true);
            valA = f.get(this.personA);
            f = this.personB.getClass().getDeclaredField(field);
            f.setAccessible(true);
            valB = f.get(this.personB);

            int diff = comp.compare((String) valA, (String) valB);
            System.out.println("diff: " + diff);
            if (diff != 0) {
                return diff;
            }
        }
        return 0;
    }

    public static Comparator<String> comparatorGenerator() {
        return Exercise_3_7.comparatorGenerator(Collections.emptySet());
    }

    public static Comparator<String> comparatorGenerator(Set<Exercise_3_7.Mode> flags) {

        return (s, t) -> {
            if (flags.contains(Exercise_3_7.Mode.COMPARE_REVERSED)) {
                String tmp = s;
                s = t;
                t = tmp;
            }
            if (flags.contains(Exercise_3_7.Mode.COMPARE_CASE_INSENSITIVE)) {
                s = s.toLowerCase();
                t = t.toLowerCase();
            }
            if (flags.contains(Exercise_3_7.Mode.COMPARE_SPACE_INSENSITIVE)) {
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
