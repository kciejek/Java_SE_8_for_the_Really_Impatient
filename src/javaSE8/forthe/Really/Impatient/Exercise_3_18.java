package javaSE8.forthe.Really.Impatient;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

public class Exercise_3_18<T, R> implements Function<T, R> {
    @Override
    public R apply(T t) {
        System.out.println("Exercise_3_18");
        return null;
    }
/*18. Implement a version of the unchecked method in Section 3.8, “Dealing with
    Exceptions,” on page 58, that generates a Function<T, U> from a lambda that
throws checked exceptions. Note that you will need to find or provide a
    functional interface whose abstract method throws arbitrary exceptions.*/

    @FunctionalInterface
    interface Unchecked<T> {

        void uncheck() throws Throwable;

    }


    public static void main(String[] args) {
        Exercise_3_18.uncheckedWithFunction((x) -> {
            System.out.println("aa");
            return null;
        });
    }

    public static <T> Supplier<T> unchecked(Callable<T> f) {
        return () -> {
            try {
                return f.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } catch (Throwable t) {
                throw t;
            }
        };
    }

    public static <T, R> Function<T, R> uncheckedWithFunction(Function<T, R> f) {
        return (x) -> {
            try {
                return f.apply(x);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } catch (Throwable t) {
                try {
                    throw t;
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            return null;
        };
    }
}
