package Binary_Tree;

import java.io.*;
import java.util.*;

public class traversalLevelOrder {
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

  public static void levelOrder(Node node) {
    // Approach 1.(PQ & CQ)
    ArrayDeque<Node> pq = new ArrayDeque<>();
    ArrayDeque<Node> cq = new ArrayDeque<>();
    pq.add(node);

    while(pq.size()>0){
        Node temp = pq.remove();
        System.out.print(temp.data + " ");

        if(temp.left != null){
            cq.add(temp.left);
        }

        if(temp.right != null){
            cq.add(temp.right);
        }

        if(pq.size() == 0){
            pq = cq;
            cq = new ArrayDeque<>();
            System.out.println();
        }
    }
}

  public static void levelOrderCount(Node node){
      // Approach 2.(count)
      ArrayDeque<Node> pq = new ArrayDeque<>();
      pq.add(node);

      while(pq.size() > 0){
          int count = pq.size();
          for(int i=0; i<count; i++){
              Node temp = pq.remove();
              System.out.print(temp.data + " ");

              if(temp.left != null){
                  pq.add(temp.left);
              }

              if(temp.right != null){
                  pq.add(temp.right);
              }
          }
          System.out.println();
      }
  }

  public static void levelOrderDelim(Node node){
      // Approach 3.(delimitter)
      ArrayDeque<Node> q = new ArrayDeque<>();
      q.add(node);
      Node delim = new Node(-1, null, null);
      q.add(delim);

      while(q.size() > 0){
          Node temp = q.remove();

          if(temp.data == -1){
              System.out.println();
              if(q.size() > 0){
                  q.add(temp);
              }
              continue;
          }

          System.out.print(temp.data + " ");

          if(temp.left != null){
              q.add(temp.left);
          }

          if(temp.right != null){
              q.add(temp.right);
          }
      }
  }

  static class Lpair{
      Node node;
      int level;
  }

  public static void levelOrderPair(Node node){
      // Approach 4.(Pair)
      ArrayDeque<Lpair> q = new ArrayDeque<>();
      Lpair rp = new Lpair();
      rp.node = node;
      rp.level = 1;
      q.add(rp);
      int level = 1;

      while(q.size() > 0){
          Lpair temp = q.remove();
          if(temp.level > level){
              level = temp.level;
              System.out.println();
          }

          System.out.print(temp.node.data + " ");
          if(temp.node.left != null){
              Lpair leftp = new Lpair();
              leftp.node = temp.node.left;
              leftp.level = temp.level + 1;
              q.add(leftp);
          }

          if(temp.node.right != null){
              Lpair rightp = new Lpair();
              rightp.node = temp.node.right;
              rightp.level = temp.level +1;
              q.add(rightp);
          }
      }
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
    //levelOrder(root);
    //levelOrderCount(root);
    levelOrderDelim(root);
  }

}
