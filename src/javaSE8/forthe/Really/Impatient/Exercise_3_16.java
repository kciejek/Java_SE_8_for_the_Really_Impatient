package javaSE8.forthe.Really.Impatient;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Exercise_3_16 {
/*
16. Implement the doInOrderAsync of Section 3.8, “Dealing with Exceptions,” on
    page 58, where the second parameter is a BiConsumer<T, Throwable>. Provide
    a plausible use case. Do you still need the third parameter?
*/

    public static void main(String[] args) {

        Exercise_3_16.doInOrderAsync(() -> {
            System.out.println("first"); return 0;
        }, (r,t) -> {
            System.out.println(t.getMessage());
        });
    }


    public static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second) {
        Thread t = new Thread() {
            public void run() {
                T result = null;
                try {
                    result = first.get();
                    throw new Exception("example exception");
                } catch (Throwable t) {
                    second.accept(result,t);
                }
            }
        };
        t.start();
    }

}
