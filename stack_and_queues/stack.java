package stack_and_queues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class stack {
    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node(int data){
            this.data = data;
        }
    }

    public static void levelorder(Node root){
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.add(root);

        while(queue.size() > 0){
            Node temp = queue.remove();
            System.out.print(temp.data + " ");
            for(Node child: temp.children){
                queue.add(child);
            }
        }
        System.out.println(".");
    }

    public static void leverOrderLinewise(Node root){
        Queue<Node> queue = new ArrayDeque<Node>();
        Queue<Node> cqueue = new ArrayDeque<Node>();
        queue.add(root);

        while(queue.size()>0){
            Node temp = queue.remove();
            System.out.print(temp.data + " ");
            for(Node child: temp.children){
                cqueue.add(child);
            }

            if(queue.size() == 0){
                queue = cqueue;
                cqueue = new ArrayDeque<>();
                System.out.println(".");
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);

        Node twenty = new Node(20);
        root.children.add(twenty);
    
        Node thirty = new Node(30);
        root.children.add(thirty);
    
        Node forty = new Node(40);
        root.children.add(forty);
        
        Node fifty = new Node(50);
        twenty.children.add(fifty);
    
        Node sixty = new Node(60);
        twenty.children.add(sixty);
    
        Node seventy = new Node(70);
        thirty.children.add(seventy);
    
        Node eighty = new Node(80);
        thirty.children.add(eighty);
    
        Node ninety = new Node(90);
        thirty.children.add(ninety);
    
        Node hundred = new Node(100);
        forty.children.add(hundred);
    
        Node hundredten = new Node(110);
        eighty.children.add(hundredten);
    
        Node hundredtwenty = new Node(120);
        eighty.children.add(hundredtwenty);
    
        levelorder(root);
        leverOrderLinewise(root);
    }
}
