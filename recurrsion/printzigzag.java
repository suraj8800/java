package recurrsion;
import java.io.*;
import java.util.*;
public class printzigzag {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pzz(n);
    }
    // E => pzz(3) = 3 211121112 3 211121112 3
    // F => pzz(2) = 2 111 2 111 2
    // EWF => pzz(3) = 3 pzz(2) 3 pzz(2) 3
    public static void pzz(int n){
        if(n == 0){
            return;
        }
        System.out.print(n + " ");
        pzz(n-1);
        System.out.print(n + " ");
        pzz(n-1);
        System.out.print(n + " ");
    }
}

