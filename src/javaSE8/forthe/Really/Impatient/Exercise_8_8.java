package javaSE8.forthe.Really.Impatient;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Exercise_8_8 {
/*8. Write a program that demonstrates the benefits of the CheckedQueue class.*/

    public static void main(String[] args) {

        Queue<Integer> queue = Collections.checkedQueue(new LinkedList<Integer>(), Integer.class);
        queue.offer(1);
        queue.offer(2);
        //queue.offer("three");
        System.out.println(queue);

    }
}
