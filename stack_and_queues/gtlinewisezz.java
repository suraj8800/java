package stack_and_queues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

import Linked_List.Get_value.LinkedList;

public class gtlinewisezz {
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

    public static Node construct(int[] arr){
        Node root = null;
        Stack<Node> stack = new Stack<>();

        for(int val: arr){
            if(val != -1){
                Node node = new Node(val);
                stack.push(node);
            }else{
                Node node = stack.pop();

                if(stack.size()>0){
                    Node parent = stack.peek();
                    parent.children.add(node);
                } else{
                    root = node;
                }
            }
        }
        return root;
    }

    public static void linewisezz(Node root){
        Stack<Node> ms = new Stack<>();
        Stack<Node> cs = new Stack<>();
        ms.push(root);
        int level = 1;

        while(ms.size()>0){
            Node temp = ms.pop();
            System.out.print(temp.data+" ");

            if(level%2 == 0){
                for(int i=temp.children.size()-1; i>=0; i--){
                    Node child = temp.children.get(i);
                    cs.push(child);
                }
            }else{
                for(int i=0; i<temp.children.size(); i++){
                    Node child = temp.children.get(i);
                    cs.push(child);
                }
            }

            if(ms.size() == 0){
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }
        }
        

    }

    public static void levelOederLinewisezz(Node root){
        LinkedList<Node> que = new LinkedList<>();
        LinkedList<Node> st = new LinkedList<>();

        que.add(root);
        int level = 0;
        while(que.size() != 0){
            int currSize = que.size();
            while(currSize--> 0){
                if(level % 2 ==0){
                    Node temp = que.removeFirst();
                    System.out.print(temp.data + " ");
                    for(int i=0; i<temp.children.size(); i++){
                        st.addFirst(temp.children.get(i));
                    }
                } else{
                    for(int i=temp.children.size()-1; i>=0; i--){
                        st.addFirst(temp.children.get(i));
                    }
                }
                level++;
                System.out.println();
                LinkedList<Node> t = que;
                que =st;
                st =t;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = construct(arr);
        //levelorder(root);
        leverOrderLinewise(root);
        linewisezz(root);
    }
}
