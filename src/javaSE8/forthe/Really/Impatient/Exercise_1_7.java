package javaSE8.forthe.Really.Impatient;

public class Exercise_1_7 {
    public static void main(String[] args) {

/*      7. Write a static method andThen that takes as parameters two Runnable instances
        and returns a Runnable that runs the first, then the second. In the main method,
        pass two lambda expressions into a call to andThen, and run the returned
        instance.*/

        Runnable one = () ->
        {
            try {
                System.out.println("One");
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        };

        Runnable two = () ->
        {
            try {
                System.out.println("Two");
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        };

        andThen(one, two).run();
    }


    private static Runnable andThen(Runnable one, Runnable two){
        return () -> { one.run(); two.run();};
    }

}
