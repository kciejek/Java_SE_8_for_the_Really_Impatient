package javaSE8.forthe.Really.Impatient;

import java.util.stream.IntStream;

public class Exercise_2_6 {
/*6. The characterStream method in Section 2.3, “The filter, map, and flatMap Methods,”
    on page 25, was a bit clumsy, first filling an array list and then turning it
    into a stream. Write a stream-based one-liner instead. One approach is to
    make a stream of integers from 0 to s.length() - 1 and map that with the
    s::charAt method reference.*/

/*
    public static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray()) result.add(c);
        return result.stream();
    }
*/

    public static void main(String[] args) {

        String s =  "This is Java 8";
        IntStream.range(0, s.length()).mapToObj( i -> s.charAt(i)).forEach(System.out::println);

    }

}
