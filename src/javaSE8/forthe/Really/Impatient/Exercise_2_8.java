package javaSE8.forthe.Really.Impatient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise_2_8 {
/*
8. Write a method public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
    that alternates elements from the streams first and second, stopping when
    one of them runs out of elements.
*/

    public static void main(String[] args) {

        Stream<String> f = Stream.of("Write","a","method","public","static");
        Stream<String> s = Stream.of("that", "alternates", "elements", "from", "the", "streams");
        Exercise_2_8.zip(f,s).forEach(System.out::println);

    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        List<T> altElems = new ArrayList<>();

        Iterator<T> firstIter = first.collect(Collectors.toList()).iterator();
        Iterator<T> secondIter = second.collect(Collectors.toList()).iterator();

        while(firstIter.hasNext() && secondIter.hasNext()){
            altElems.add(firstIter.next());
            altElems.add(secondIter.next());
        }

        return altElems.stream();

    }

}
