package Binary_Tree;

import java.io.*;
import java.util.*;

public class diameter {
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

  public static int height(Node node) {
    if (node == null) {
      return -1;
    }

    int lh = height(node.left);
    int rh = height(node.right);

    int th = Math.max(lh, rh) + 1;
    return th;
  }

  static int dia = 0;
  public static int diameter1(Node node) {
    // approcah 1.(static variabel)
    if(node == null){
        return -1;
    }

    int leftheigth = diameter1(node.left);
    int rightheight = diameter1(node.right);

    int height = Math.max(leftheigth, rightheight) + 1;

    if(leftheigth + rightheight + 2 > dia){
        dia = leftheigth + rightheight + 2;
    }

    return height;
  }

  static class DiaMover{
      int dia = 0;
  }

  public static int diameter2(Node node, DiaMover dm){
      // approach 2.(diamover)
      
      if(node == null){
          return -1;
      }

      int lh = diameter2(node.left, dm);
      int rh = diameter2(node.right, dm);

      int ht = Math.max(lh, rh) + 1;

      if(lh+rh+2 > dm.dia){
          dm.dia = lh+rh+2;
      }

      return ht;
  }

  public static int diameter3(Node node){
      //approach 3.(factor1, factor2, factor3
      
      if(node == null){
          return 0;
      }
      int leftheight = height(node.left);
      int rightheight = height(node.right);
      int rootdistance = leftheight + rightheight + 2;

      int leftdistance = diameter3(node.left);
      int rightdistance = diameter3(node.right);

      int diameter = Math.max(rootdistance, Math.max(leftdistance, rightdistance));
      return diameter;
  }

  static class DiaPair{
      int height = -1;
      int dia = 0;
  }

  public static DiaPair diameter4(Node node){
      if(node == null){
          DiaPair bp = new DiaPair();
          bp.height = -1;
          bp.dia = 0;
          return bp;
      }
      DiaPair lp = diameter4(node.left);
      DiaPair rp = diameter4(node.right);

      DiaPair mp = new DiaPair();
      mp.dia = Math.max(lp.height + rp.height + 2, Math.max(lp.dia, rp.dia));
      mp.height = Math.max(lp.height, rp.height) +1 ;

      return mp;
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

    // int height = 0;
    // height = diameter1(root);
    // System.out.println(dia);

    // DiaMover dm = new DiaMover();
    // diameter2(root, dm);
    // System.out.println(dm.dia);

    // int dia = diameter3(root);
    // System.out.println(dia);

    DiaPair dp = diameter4(root);
    System.out.println(dp.dia);
  }

}
