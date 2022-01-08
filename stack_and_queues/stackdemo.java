package stack_and_queues;

import java.util.Stack;

public class stackdemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println(stack.peek());
        stack.pop();

        System.out.println(stack.peek());
        stack.pop();

        System.out.println(stack.peek());
        stack.pop();

        System.out.println(stack.pop());
        
        

    }
}

