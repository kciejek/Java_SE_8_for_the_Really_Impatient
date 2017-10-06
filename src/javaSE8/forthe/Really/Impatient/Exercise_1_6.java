package javaSE8.forthe.Really.Impatient;

public class Exercise_1_6 implements Runnable {
    @Override
    public void run() {
        System.out.println("aaaa");
    }

    interface RunnableEx {

        void runEx() throws Exception;

        static Runnable uncheck(RunnableEx runner) {
            try {
                runner.runEx();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }




    public static void main(String[] args) {
       /* Didn’t you always hate it that you had to deal with checked exceptions in a
        Runnable? Write a method uncheck that catches all checked exceptions and turns
        them into unchecked exceptions. For example,
        new Thread(uncheck(
                () -> { System.out.println("Zzz"); Thread.sleep(1000); })).start();
                   // Look, no catch (InterruptedException)!
        Hint: Define an interface RunnableEx whose run method may throw any exceptions.
                Then implement public static Runnable uncheck(RunnableEx runner). Use a
        lambda expression inside the uncheck function.
        Why can’t you just use Callable<Void> instead of RunnableEx?*/

        //as is
        new Thread(() ->
        {
            try {
                System.out.println("Zzz");
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }).start();

        new Thread(RunnableEx.uncheck( () -> { System.out.println("Zzz uncheck"); Thread.sleep(1000); } )).start();

        //Why can’t you just use Callable<Void> instead of RunnableEx?
        //You need to add return statemnt to meet the Callable<Void> return requirement, for example: () -> { System.out.println("Zzz uncheck"); Thread.sleep(1000); return null;}


    }
}
