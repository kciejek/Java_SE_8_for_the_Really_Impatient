package javaSE8.forthe.Really.Impatient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise_2_9 {
    private List<String> res;
/*9. Join all elements in a Stream<ArrayList<T>> to one ArrayList<T>. Show how to do
            this with the three forms of reduce.*/

    public static void main(String[] args) {

        List<String> lstOne = new ArrayList<>();
        lstOne.add("One");
        lstOne.add("Two");
        lstOne.add("Three");

        List<String> lstTwo = new ArrayList<>();
        lstTwo.add("1");
        lstTwo.add("2");
        lstTwo.add("3");

        List<String> lstThree = new ArrayList<>();
        lstThree.add("Aaa");
        lstThree.add("Bbb");
        lstThree.add("Ccc");

        Stream<List<String>> s = Stream.of(lstOne, lstTwo, lstThree);

        List<String> res = s.map( x -> String.join(", ", x)).collect(Collectors.toList());
        for (String elem : res) {
            System.out.println(elem);
        }
    }
}
