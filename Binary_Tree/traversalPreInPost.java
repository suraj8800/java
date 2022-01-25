package Binary_Tree;

import java.io.*;
import java.util.*;

//import stack_and_queues.stack;

public class traversalPreInPost {
public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
    this.data = data;
    this.left = left;
    this.right = right;
    }
}

public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
    this.node = node;
    this.state = state;
    }
}

public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
    Pair top = st.peek();
    if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
        top.node.left = new Node(arr[idx], null, null);
        Pair lp = new Pair(top.node.left, 1);
        st.push(lp);
        } else {
        top.node.left = null;
        }

        top.state++;
    } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
        top.node.right = new Node(arr[idx], null, null);
        Pair rp = new Pair(top.node.right, 1);
        st.push(rp);
        } else {
        top.node.right = null;
        }

        top.state++;
    } else {
        st.pop();
    }
    }

    return root;
}

public static void display(Node node) {
    if (node == null) {
    return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
}

public static void preOrder(Node node){
    if(node == null){
        return;
    }
    System.out.print(node.data + "->");
    preOrder(node.left);
    preOrder(node.right);
}

public static void inOrder(Node node){
    if(node == null){
        return;
    }

    inOrder(node.left);
    System.out.print(node.data + "->");
    inOrder(node.right);
}

public static void postOrder(Node node){
    if(node == null){
        return;
    }

    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.data + "->");
}

static class Tpair{
    Node node;
    int state;

    Tpair(Node node, int state){
        this.node = node;
        this.state = state;
    }
}
public static void iterativePrePostInTraversal(Node node) {
    // write your code here
    Stack<Tpair> stack = new Stack<>();
    Tpair rootp = new Tpair(node, 1);
    stack.push(rootp);

    String pre = "";
    String in = "";
    String post = "";

    while(stack.size()>0){
        Tpair top = stack.peek();
        if(top.state == 1){
            // pre
            pre += top.node.data + " ";
            if(top.node.left != null){
                Tpair left = new Tpair(top.node.left, 1);
                stack.push(left);
            }
        } else if(top.state == 2){
            //in
            in += top.node.data + " ";
            if(top.node.right != null){
                Tpair right = new Tpair(top.node.right, 1);
                stack.push(right);
            }
        } else{
            // post
            post += top.node.data + " ";
            stack.pop();
        }
        top.state++;
    }
    System.out.println(pre);
    System.out.println(in);
    System.out.println(post);
}

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
    if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
    } else {
        arr[i] = null;
    }
    }

    Node root = construct(arr);
    iterativePrePostInTraversal(root);
    // preOrder(root);
    // System.out.println(".");
    // inOrder(root);
    // System.out.println(".");
    // postOrder(root);
    // System.out.println(".");
}

}
