package javaSE8.forthe.Really.Impatient;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

interface Collection2<T> extends Collection {

    default void forEachIf(Consumer<T> action, Predicate<T> filter) {
        this.stream().filter(filter).forEach(action);
    }

}

public class Exercise_1_9 implements Collection2, List {
/*    9. Form a subclass Collection2 from Collection and add a default method void
    forEachIf(Consumer<T> action, Predicate<T> filter) that applies action to each
    element for which filter returns true. How could you use it? */


    public static void main(String[] args) {

        Stream<String> s = Stream.of("gently", "down", "the", "stream");
        List<String> l = new ArrayList();
        l.add("gently");
        l.add("down");
        l.add("the");
        l.add("stream");
        Collection<String> c = new ArrayList<String>();//(Collection2) l;
        Exercise_1_9 c2 = new Exercise_1_9();

        c2.add("gently");
        c2.add("down");
        c2.add("the");
        c2.add("stream");
        System.out.println("a: " + c2.get(0));
        for (Iterator<String> iter = c2.iterator(); iter.hasNext(); ) {
            String element = iter.next();
            System.out.println("E: " + element);
        }
        //System.out.println("List: " + c2.toArray(new String[0]));
        //c2.forEachIf(System.out::println, );
        //Collection c = Stream.of("gently", "down", "the", "stream");

        //Collection2 c = new Collection2();
        //c.
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
