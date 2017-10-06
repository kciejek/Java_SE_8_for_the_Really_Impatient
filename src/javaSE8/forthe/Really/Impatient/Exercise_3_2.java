package javaSE8.forthe.Really.Impatient;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Exercise_3_2 {
/*2. When you use a ReentrantLock, you are required to lock and unlock with the
            idiom
    myLock.lock();
    try {
        some action
    } finally {
        myLock.unlock();
    }
    Provide a method withLock so that one can call
    withLock(myLock, () -> { some action })*/


    private final ReentrantLock myLock = new ReentrantLock();

    public static void main(String[] args) {

        Exercise_3_2 exer = new Exercise_3_2();
        exer.withLock(exer.myLock, () -> {
            System.out.println("Locked action.");
        });


    }

    private void withLock(Lock myLock, LockedAction la) {
        myLock.lock();
        try {
            la.action();
        } finally {
            myLock.unlock();
        }
    }

    public interface LockedAction {

        void action();
    }

}


