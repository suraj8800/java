package Binary_Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.lang.reflect.Constructor;
import java.util.Stack;
// BINARY TREE INTRO WITH CONSTRUCT AND DISPLAY

public class binary {
    public static class Node {
        int data;
        Node left;
        Node right;        
    } 

    public static class Pair {
        Node node;
        int state;
    }
    public static Node construct(Integer[] arr){
        Stack<Pair> st = new Stack<>();
        
        Node root = new Node();
        root.data = arr[0];

        Pair rootp = new Pair();
        rootp.node = root;
        rootp.state = 1;

        st.push(rootp);
        int idx =1;
        
        while(st.size() > 0){
            Pair peekp = st.peek();

            if(peekp.state == 1){
                // left
                if(arr[idx] !=null){
                    Node lc = new Node();
                    lc.data = arr[idx];
                    peekp.node.left = lc;

                    Pair lp = new Pair();
                    lp.node = lc ;
                    lp.state = 1;
                    st.push(lp);
                }
                peekp.state++;
                idx++;
            } else if(peekp.state == 2){
                //rigth
                if(arr[idx] !=null){
                    Node rc = new Node();
                    rc.data = arr[idx];
                    peekp.node.right = rc;

                    Pair rp = new Pair();
                    rp.node = rc ;
                    rp.state = 1;
                    st.push(rp);
                }
                peekp.state++;
                idx++;
            }
            else if( peekp.state ==3){
                //pop
                st.pop();
            }
        }
        return root;
    }

    public static void display(Node node){
        if(node == null){
            return;
        }

        String str = " <- " + node.data + " -> ";
        String lcstr = node.left == null? ".": node.left.data + "";
        String rcstr = node.right == null? ".": node.right.data +"";
        System.out.println(lcstr + str + rcstr);

        display(node.left);
        display(node.right);
        
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
        display(root);
    }
}
