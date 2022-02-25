package Dynamic_programming;

import java.util.Scanner;

public class climbStair {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int paths = climbStair(n, new int[n+1]);
        System.out.println(paths);
    }

    static int climbStair(int n, int[] strg){

        if(n == 0 || n== 1){
            return 1;
        }else if(n < 0){
            return 0;
        }

        if(strg[n] != 0){
            return strg[n];
        } 
        int nm1 = climbStair(n-1, strg);
        int nm2 = climbStair(n-2, strg);
        int nm3 = climbStair(n-3, strg);
        int path = nm1 + nm2 + nm3;

        strg[n] = path;
        return path;
    }
}
