package javaSE8.forthe.Really.Impatient;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise_3_1 {
/*
1. Enhance the lazy logging technique by providing conditional logging. A
    typical call would be logIf(Level.FINEST, () -> i == 10, () -> "a[10] = " + a[10]).
    Don’t evaluate the condition if the logger won’t log the message.
*/

    private static final Logger LOGGER = Logger.getLogger( Exercise_3_1.class.getName() );

    public static void main(String[] args) {

        int x = 1;
        int y = 2;
        LOGGER.info("x: " + x + ", y: " + y);
        Exercise_3_1.logIf(Level.INFO, () -> x == 2, () -> y == 1);

    }

    public static void logIf(Level level, Supplier<Boolean>... msg){
        if (level.getName().equals(Level.INFO.getName())){
            for (Supplier<Boolean> m : msg) {
                LOGGER.info(String.valueOf(m.get()));
            }
        }
    }
}
