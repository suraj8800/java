package stack_and_queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class queuedemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);

        System.out.println(queue);
        System.out.println(queue.peek());
        queue.remove();

        System.out.println(queue);
        System.out.println(queue.peek());
        queue.remove();

        System.out.println(queue);
        System.out.println(queue.peek());
        queue.remove();

    }
}
