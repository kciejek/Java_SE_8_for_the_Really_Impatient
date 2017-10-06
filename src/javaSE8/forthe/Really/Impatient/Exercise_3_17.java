package javaSE8.forthe.Really.Impatient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Exercise_3_17 {
/*17. Implement a doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable>)
    method that executes first and second in parallel, calling the handler if
    either method throws an exception.*/

    public static void main(String[] args) throws InterruptedException {

        Exercise_3_17.doInParallelAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("first thread");
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }

                }, () -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("second thread");
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }

                },
                System.out::println
        );
    }

    public static void doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler) throws InterruptedException {

        ExecutorService pool = Executors.newCachedThreadPool();
        try {
            pool.submit(first);
            pool.submit(second);
        } catch (Throwable t) {
            handler.accept(t);
        } finally {
            pool.shutdown();
            pool.awaitTermination(1, TimeUnit.HOURS);
        }

    }

}
