package Binary_Tree;

import java.io.*;
import java.util.*;

public class isLargestBST {
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

  static class BSTclass{
      int min = Integer.MAX_VALUE;
      int max  = Integer.MIN_VALUE;
      boolean ISBST = true;
      Node largestBSTNode = null;
      int largestBSTSize = 0;
  }

  public static BSTclass largestBST(Node node){
      if(node == null){
          return new BSTclass();
      }

      BSTclass ls = largestBST(node.left);
      BSTclass rs = largestBST(node.right);

      boolean isNodeBST = (ls.max < node.data && rs.min > node.data);

      BSTclass myNodeResult = new BSTclass();

      myNodeResult.min = Math.min(node.data, Math.min(ls.min, rs.min));
      myNodeResult.max = Math.max(node.data, Math.max(ls.max, rs.max));

      myNodeResult.ISBST = (ls.ISBST == true)&&(rs.ISBST == true) && (isNodeBST == true);

      if(myNodeResult.ISBST == true){
          myNodeResult.largestBSTNode = node;
          myNodeResult.largestBSTSize = ls.largestBSTSize + rs.largestBSTSize + 1;
      }else if(ls.largestBSTSize > rs.largestBSTSize){
          myNodeResult.largestBSTNode = ls.largestBSTNode;
          myNodeResult.largestBSTSize = ls.largestBSTSize;
      } else if(rs.largestBSTSize > ls.largestBSTSize){
          myNodeResult.largestBSTNode = rs.largestBSTNode;
          myNodeResult.largestBSTSize = rs.largestBSTSize;
      }

      return myNodeResult;
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
    BSTclass isLBST = largestBST(root);
    System.out.println(isLBST.largestBSTNode.data + "@" + isLBST.largestBSTSize);
    // write your code here
  }

}
