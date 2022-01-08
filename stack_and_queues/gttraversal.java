package stack_and_queues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

import Linked_List.Get_value.LinkedList;

public class gttraversal {
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

    // 6 dec
    public static void traversals(Node node){
        System.out.println("Node Pre " + node.data);
    
        for(Node child: node.children){
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }
        System.out.println("Node Post " + node.data);
      }

    public static void serialize(Node node, ArrayList<Integer> list){
        list.add(node.data);
        for(Node child: node.children){
            serialize(child, list);
        }
        list.add(-1);
    }

    public static void mirror(Node node){
        // write your code here
        for(Node child: node.children){
            mirror(child);
        }
        Collections.reverse(node.children);
      }

    public static void removeLeave(Node node){
        //remove your own leaves
        for(int i= node.children.size()-1; i>=0; i--){
            Node child = node.children.get(i);
            if(child.children.size() == 0){
                node.children.remove(i);
            }
        }
        
        // request the children
        for(Node child: node.children){
            removeLeave(child);
        }
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = construct(arr);

        ArrayList<Integer> list = new ArrayList<>();
        //levelorder(root);
        leverOrderLinewise(root);
        linewisezz(root);
        serialize(root, list);
    }
}
